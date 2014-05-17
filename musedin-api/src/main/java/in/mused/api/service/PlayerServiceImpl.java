package in.mused.api.service;

import flexjson.JSONDeserializer;
import in.mused.api.domain.Activity;
import in.mused.api.domain.Player;
import in.mused.api.domain.Song;
import in.mused.api.domain.User;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Async;

@PropertySource("classpath:/META-INF/spring/application-${buildenv}.properties")
public class PlayerServiceImpl implements PlayerService {

    Logger log = LogManager.getLogger(PlayerServiceImpl.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ServletContext servletContext;

    @Resource(name = "build")
    private Properties build;

    @Autowired
    private transient MailSender mailTemplate;

    public List<java.util.Map> search(Map query) {
        return playerRepository.search(query);
    }

    @Override
    public Player getActivePlayer(User user) {
        return playerRepository.findByUserIdAndActive(user.getId(), true);
    }

    public Player getPlayerByCode(String code) {
        return playerRepository.findByCode(code);
    }

    public void updatePlaylistSong(ObjectId playerId, Song song) {
        playerRepository.updatePlaylistSong(playerId, song);
    }

    public void pushPlaylistSong(ObjectId playerId, Song song) {
        playerRepository.pushPlaylistSong(playerId, song);
    }

    public void updatePlayerShallow(Player player) {
        playerRepository.updatePlayerShallow(player);
    }

    public void destroyPlaylistSong(ObjectId playerId, Song song) {
        playerRepository.destroyPlaylistSong(playerId, song);
    }

    public void pushActivity(ObjectId playerId, Activity activity) {
        playerRepository.pushActivity(playerId, activity);
    }

    public Song findSong(ObjectId playerId, ObjectId songId) {
        return playerRepository.findSong(playerId, songId);
    }

    @Async
    public void updateSongDetails(ObjectId playerId, Song song) {
        try {
            String term = sanitize(song.getTitle());
            HttpClient httpClient = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("itunes.apple.com/").setPath("/search").setParameter("term", term).setParameter("entity", "song").setParameter("limit", "1").setParameter("media", "music");
            URI uri = builder.build();
            HttpGet httpget = new HttpGet(uri);
            HttpResponse response = httpClient.execute(httpget);
            if (response.getStatusLine().getStatusCode() != 200) {
                log.error("method: updateSongDetails, msg: Unable to retrieve song details, playerId: " + playerId + ", songId: " + song.getId() + ", term: " + term);
                song.setTitle(song.getTitle().replaceAll("\\.mp3", ""));
            } else {
                String json = EntityUtils.toString(response.getEntity());
                Map<String, Object> map = new JSONDeserializer<Map<String, Object>>().deserialize(json);
                if (((ArrayList) map.get("results")).size() > 0) {
                    log.info("method: updateSongDetails, msg: Got song details, playerId: " + playerId + ", songId: " + song.getId() + ", term: " + term);
                    Map<String, String> vmap = (Map<String, String>) ((ArrayList) map.get("results")).get(0);
                    if (vmap.containsKey("artworkUrl100")) {
                        song.setIconUrl(vmap.get("artworkUrl100"));
                    }
                    if (vmap.containsKey("trackName")) {
                        song.setTitle(vmap.get("trackName"));
                    } else {
                        if (vmap.containsKey("trackCensoredName")) {
                            song.setTitle(vmap.get("trackCensoredName"));
                        }
                    }
                    if (vmap.containsKey("collectionName")) {
                        song.setAlbum(vmap.get("collectionName"));
                    } else {
                        if (vmap.containsKey("collectionCensoredName")) {
                            song.setAlbum(vmap.get("collectionCensoredName"));
                        }
                    }
                    if (vmap.containsKey("artistName")) song.setArtist(vmap.get("artistName"));
                    if (vmap.containsKey("primaryGenreName")) song.setGenre(vmap.get("primaryGenreName"));
                } else {
                    log.info("updateSongDetails No song details available! playerId: " + playerId + " songId: " + song.getId() + " term: " + term);
                    song.setTitle(song.getTitle().replaceAll("\\.mp3", ""));
                }
            }
        } catch (Exception e) {
            log.error("Unable to retrieve song details!", e);
        }
        updatePlaylistSong(playerId, song);
    }

    private String sanitize(String s) {
        String x = s.replaceAll("\\.mp3", "");
        x = x.replaceAll("[^A-Za-z0-9 ]", "");
        return x;
    }

    public String getBuildNumber() {
        return build.getProperty("build.number", "buildNumber");
    }

    public String getBuildVersion() {
        return build.getProperty("build.version", "buildVersion");
    }

    public String getBuildTime() {
        return build.getProperty("build.time", "buildTime");
    }

    public String getBuildName() {
        return build.getProperty("build.name", "buildName");
    }

    public String getBuildEnv() {
        return environment.getProperty("build.env", "buildEnv");
    }

    public String getAppUrl() {
        return servletContext.getContextPath();
    }

    public String getServerInfo() {
        return servletContext.getServerInfo();
    }

    public String getAppPath() {
        return servletContext.getRealPath("/");
    }

    @Async
    public void updateLastActivityTime(ObjectId playerId) {
        playerRepository.updateLastActivityTime(playerId);
    }

    @Async
    public void updateLastPolledTime(ObjectId playerId) {
        playerRepository.updateLastPolledTime(playerId);
    }

    @Async
    public void sendMessage(String mailFrom, String subject, String mailTo, String message) {
        org.springframework.mail.SimpleMailMessage mailMessage = new org.springframework.mail.SimpleMailMessage();
        mailMessage.setFrom(mailFrom);
        mailMessage.setSubject(subject);
        mailMessage.setTo(mailTo);
        mailMessage.setText(message);
        mailTemplate.send(mailMessage);
    }
}

package in.mused.api.service;

import java.util.List;
import java.util.Map;

import in.mused.api.domain.Activity;
import in.mused.api.domain.Player;
import in.mused.api.domain.Song;
import in.mused.api.domain.User;

import org.bson.types.ObjectId;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { in.mused.api.domain.Player.class })
public interface PlayerService {
	public List<Map> search(Map query);
	
	public Player getActivePlayer(User user);
	public Player getPlayerByCode(String code);
	
	public void updatePlaylistSong(ObjectId playerId, Song song);
	public void pushPlaylistSong(ObjectId playerId, Song song);
	public void updatePlayerShallow(Player player);
	public void updateSongDetails(ObjectId playerId, Song song);
	public void destroyPlaylistSong(ObjectId playerId, Song song);
	public void pushActivity(ObjectId playerId, Activity activity);
	
	public Song findSong(ObjectId playerId, ObjectId songId);
	
	public String getBuildNumber();
	public String getBuildVersion();
	public String getBuildTime();
	public String getBuildName();
	public String getBuildEnv();
	public String getAppUrl();
	public String getAppPath();
	public String getServerInfo();
	
	public void updateLastActivityTime(ObjectId playerId);
	public void updateLastPolledTime(ObjectId playerId);
	
	public void sendMessage(String mailFrom, String subject, String mailTo, String message);
}

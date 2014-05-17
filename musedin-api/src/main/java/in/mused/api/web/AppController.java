package in.mused.api.web;

import flexjson.JSONSerializer;
import in.mused.api.domain.Activity;
import in.mused.api.domain.Player;
import in.mused.api.domain.Song;
import in.mused.api.domain.User;
import in.mused.api.service.PlayerService;
import in.mused.api.service.SongService;
import in.mused.api.service.UserService;
import in.mused.api.util.ObjectIdTransformer;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	Logger log = LogManager.getLogger(AppController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	SongService songService;
	
	@Autowired
    PlayerService playerService;
	
    @RequestMapping(value = "/player", produces = "text/html")
    public String init(Model uiModel, Principal principal, HttpServletRequest request) {    
    	log.info("user: "+principal.getName()+", method: init, msg: Initializing Player for user");
    	
    	User user = userService.findUserByUsername(principal.getName());
    	
    	Player player = getActivePlayer(user);;
    	if(player!=null){
    		log.info(player.toJson());
    	}else{
    		player = new Player();	
    		player.setActive(true);
    		String uuid = UUID.randomUUID().toString().toLowerCase();
    		player.setCode(uuid.substring(uuid.length()-5,uuid.length()));
    		player.setUserId(user.getId());
    		player.setPlaying(false);

    		Set<Activity> activities = new HashSet<Activity>();
    		Activity activity = new Activity();
    		activity.setId(ObjectId.get());
    		activity.setCode("100");
    		activity.setMsg("New Player created by "+user.getDisplayname());
    		activity.setTstamp(""+new Date().getTime());
    		activities.add(activity);
    		player.setActivities(activities);
    		
    		//player.setPlaylistSongs(dummyPlaylist());
    		//playerService.savePlayer(player);
    	}
        	
    	JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        String playlistSongsJson = serializer.exclude("*.class").serialize(player.getPlaylistSongs());
        String activitiesJson = serializer.exclude("*.class").serialize(player.getActivities());
    	
        uiModel.addAttribute("playerJson", player.toJson());
        uiModel.addAttribute("playlistSongsJson", playlistSongsJson);
    	uiModel.addAttribute("activitiesJson", activitiesJson);
    	//uiModel.addAttribute("playerIdJson", "{\"id\": \""+player.getId()+"\"}");
    	
    	uiModel.addAttribute("buildNumber", playerService.getBuildNumber());
    	uiModel.addAttribute("buildVersion", playerService.getBuildVersion());
    	uiModel.addAttribute("buildTime", playerService.getBuildTime());
    	uiModel.addAttribute("buildName", playerService.getBuildName());
    	uiModel.addAttribute("buildEnv", playerService.getBuildEnv());
    	//uiModel.addAttribute("appUrl", playerService.getAppUrl());
    	uiModel.addAttribute("appPath", playerService.getAppPath());    	
    	uiModel.addAttribute("server-info", playerService.getServerInfo());
    	uiModel.addAttribute("appEndpoint", request.getRequestURL().toString());
    	
    	uiModel.addAttribute("username", user.getDisplayname());
    	uiModel.addAttribute("userid", user.getId().toString());

        return "player";
    }
    
    private Player getActivePlayer(User user){
    	//return playerService.getActivePlayer(user);
    	return null;
    }
    
    
    @RequestMapping(value = "/", produces = "text/html")
    public String index(Model uiModel, Principal principal, HttpServletRequest request) {    
    	addUserAttribute(uiModel, principal);
        return "index";
    }    
    
    @RequestMapping(value = "/about", produces = "text/html")
    public String about(Model uiModel, Principal principal, HttpServletRequest request) {   
    	addUserAttribute(uiModel, principal);
        return "about";
    }      
    
    @RequestMapping(value = "/contact", produces = "text/html")
    public String contact(Model uiModel, Principal principal, HttpServletRequest request) {    
    	addUserAttribute(uiModel, principal);
        return "contact";
    }
    
    @RequestMapping(value = "/contact-form", headers = "Accept=application/json")
    public ResponseEntity<String> contactForm(HttpServletRequest request) {    
    	log.info("method: contactForm, msg: contact form submitted");
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        String mailFrom = request.getParameter("email");
		String subject = "Mused.in Contact Form - "+request.getParameter("subject");
		String mailTo = "info@mused.in";
		String message = "Name: "+request.getParameter("name")+"\nMessage: "+request.getParameter("message");
		
		log.info("method: contactForm, msg: contact form submitted, mailFrom: "+mailFrom+", subject: "+subject+", message: "+message);
        
		playerService.sendMessage(mailFrom, subject, mailTo, message);
		ResponseEntity<String> re = new ResponseEntity<String>("{\"success\": true}", headers, HttpStatus.OK);
        
        return re;
    }        
    
    private void addUserAttribute(Model uiModel, Principal principal){
    	if(principal != null){
    		User user = userService.findUserByUsername(principal.getName());
        	uiModel.addAttribute("username", user.getDisplayname());
        	uiModel.addAttribute("userid", user.getId().toString());
    	}
    }
      
    
    
    
    

//	private Set<Song> dummyPlaylist() {
//		Set<Song> playlist = new HashSet<Song>();
//		
//		Song s1 = new Song();
//		s1.setTitle("Metallica - One");
//		s1.setSongUrl("/");
//		s1.setAlbum("");
//		s1.setArtist("");
//		s1.setComment("");
//		s1.setGenre("");
//		s1.setIconUrl("");
//		s1.setYear("");
//		s1.setId(ObjectId.get());
//		//songService.saveSong(s1);
//		playlist.add(s1);
//
//		Song s2 = new Song();
//		s2.setTitle("Metallica - Two");
//		s2.setSongUrl("/");
//		s2.setAlbum("");
//		s2.setArtist("");
//		s2.setComment("");
//		s2.setGenre("");
//		s2.setIconUrl("");
//		s2.setYear("");
//		s2.setId(ObjectId.get());
//		//songService.saveSong(s2);
//		playlist.add(s2);
//		
//		Song s3 = new Song();
//		s3.setTitle("Metallica - Three");
//		s3.setSongUrl("/");
//		s3.setAlbum("");
//		s3.setArtist("");
//		s3.setComment("");
//		s3.setGenre("");
//		s3.setIconUrl("");
//		s3.setYear("");
//		s3.setId(ObjectId.get());
//		//songService.saveSong(s3);
//		playlist.add(s3);
//		
//		return playlist;
//	}
    
}

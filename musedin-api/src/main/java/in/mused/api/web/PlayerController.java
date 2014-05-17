package in.mused.api.web;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import in.mused.api.domain.Activity;
import in.mused.api.domain.Player;
import in.mused.api.domain.Song;
import in.mused.api.service.PlayerService;
import in.mused.api.service.SecurityService;
import in.mused.api.service.SongService;
import in.mused.api.util.ObjectIdTransformer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping(value={"/players","/api/players"})
@Controller
@RooWebScaffold(path = "players", formBackingObject = Player.class)
@RooWebJson(jsonObject = Player.class)
public class PlayerController {
	
	Logger log = LogManager.getLogger(PlayerController.class);
	
	@Autowired
	SecurityService securityService;
	
    @RequestMapping(value = "/test", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> test() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        String passwd = securityService.encodePassword("joppu@variam.com", "musedin", "admin");
        ResponseEntity<String> re = new ResponseEntity<String>(passwd, headers, HttpStatus.OK);
        return re;
    }
    
    @RequestMapping(value = "/search",method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> search(@RequestBody String json, Principal principal) {
    	log.info("user: "+principal.getName()+", method: search, query: "+json);
    	
    	JSONDeserializer<Map> deserializer = new JSONDeserializer<Map>();
    	Map map = deserializer.deserialize(json);
    	
    	List<Map> results = playerService.search(map);
    	
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        JSONSerializer serializer = new JSONSerializer();
        String resultsJson = serializer.serialize(results);
        
        return new ResponseEntity<String>(resultsJson,headers, HttpStatus.CREATED);
    }     
    
    @RequestMapping(value = "/{id}/poll", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> poll(@PathVariable("id") ObjectId id) {
    	//log.info("poll request recieved for player: "+id);
    	Player player = playerService.findPlayer(id);
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (player == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        
        Map<String, Object> map = new HashMap<String,Object>();        
        map.put("playlistSongs", player.getPlaylistSongs()==null?new HashSet():player.getPlaylistSongs());
        map.put("activities", player.getActivities()==null?new HashSet():capActivities(player.getActivities()));
        player.setActivities(new HashSet());
        player.setPlaylistSongs(new HashSet());
        player.setLastActivityTime(0);
        player.setLastPolledTime(0);        
        map.put("player", player);
        
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);        
        String json = serializer.exclude("*.class").deepSerialize(map);
        
        //System.out.println(map.get("playlistSongs"));
        //System.out.println(json);
        
        playerService.updateLastPolledTime(id);
        
        return new ResponseEntity<String>(json, headers, HttpStatus.OK);
    }
    
    private List<Activity> capActivities(Set<Activity> activities) {
    	List<Activity> tmp = new ArrayList<Activity>(activities);
    	
    	if(tmp.size()<=25) return tmp;
    			
		Collections.sort(tmp, new Comparator<Activity>() {
			public int compare(Activity o1, Activity o2) {
				return (int) (Long.parseLong(o2.getTstamp()) - Long.parseLong(o1.getTstamp()));
			}
		});
				
		return tmp.subList(0, 24);
	}

	@RequestMapping(value = "/code/{code}", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> getPlayerByCode(@PathVariable("code") String code, Principal principal) {    	
        Player player = playerService.getPlayerByCode(code.toLowerCase());
        log.info("user: "+principal.getName()+", method: getPlayerByCode, code: "+code+", msg: Found player!, playerId: "+(player==null?"null":player.getId().toString()));

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (player == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        
        Map<String, Object> map = new HashMap<String,Object>();        
        map.put("playlistSongs", player.getPlaylistSongs()==null?new HashSet():player.getPlaylistSongs());
        map.put("activities", player.getActivities()==null?new HashSet():player.getActivities());
        player.setActivities(new HashSet());
        player.setPlaylistSongs(new HashSet());
        player.setLastActivityTime(0);
        player.setLastPolledTime(0);  
        map.put("player", player);
        
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);        
        String json = serializer.exclude("*.class").deepSerialize(map);
        
        return new ResponseEntity<String>(json, headers, HttpStatus.OK);                
    }    
    
    @RequestMapping(value = "/{id}/playlistsongs", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> getPlaylistSongs(@PathVariable("id") ObjectId id) {
    	log.info("getPlaylistSongs playerId: "+id);
        Player player = playerService.findPlayer(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (player == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        String json = serializer.exclude("*.class").serialize(player.getPlaylistSongs());
        
        return new ResponseEntity<String>(json, headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}/playlistsongs/{sid}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updatePlaylistSong(@PathVariable("id") ObjectId id, @PathVariable("sid") ObjectId sid, @RequestBody String json, Principal principal) {
      	
      	
//    	Player player = playerService.findPlayer(id);
//    	//TODO optimize, use kewl query builder method in repository
//    	//http://static.springsource.org/spring-data/data-document/docs/current/reference/html/#mongo.repositories
//        Song song = Song.fromJsonToSong(json);
//        Set<Song> songs = player.getPlaylistSongs();
//        for (Song s : songs) {
//			if(s.getId().equals(song.getId())){
//				s.setUpVotes(song.getUpVotes());
//				s.setDownVotes(song.getDownVotes());
//				//update others
//			}
//		}
//
//        playerService.updatePlayer(player); 
    	
      	
      	//TODO create seperate methods for upvote/downVote
    	Song song = Song.fromJsonToSong(json);
    	log.info("user: "+principal.getName()+", method: updatePlaylistSong, playerId: "+id+", songId: "+song.getId()+", songTitle: "+song.getTitle());
    	playerService.updatePlaylistSong(id, song);
    	
    	
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/{id}/playlistsongs",method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createPlaylistSong(@PathVariable("id") ObjectId id, @RequestBody String json, Principal principal) {    	
//    	Player player = playerService.findPlayer(id);
//    	Song song = Song.fromJsonToSong(json);
//      song.setId(ObjectId.get());        
//      song = songService.getSongInfo(song);        
//      player.getPlaylistSongs().add(song);
//      playerService.updatePlayer(player); 
    	
    	Song song = Song.fromJsonToSong(json);
    	song.setId(ObjectId.get());
    	playerService.pushPlaylistSong(id, song);
    	playerService.updateSongDetails(id, song); 
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        log.info("user: "+principal.getName()+", method: createPlaylistSong, playerId: "+id+", songId: "+song.getId()+", songTitle: "+song.getTitle());
        
        return new ResponseEntity<String>("{\"id\": \""+song.getId()+"\"}",headers, HttpStatus.CREATED);
    }   
    
    @RequestMapping(value = "/{id}/activities",method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createActivity(@PathVariable("id") ObjectId playerId, @RequestBody String json, Principal principal) {    	    	
    	Activity activity = Activity.fromJsonToActivity(json);
    	activity.setId(ObjectId.get());
    	activity.setTstamp(""+new Date().getTime());
    	playerService.pushActivity(playerId, activity);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        log.info("user: "+principal.getName()+", method: createActivity, playerId: "+playerId+", activityId: "+activity.getId()+", activityCode: "+activity.getCode()+" activityMsg: "+activity.getMsg());
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("id",activity.getId().toString());
        map.put("tstamp",activity.getTstamp());
        
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        String activityJson = serializer.exclude("*.class").serialize(map);
        
        playerService.updateLastActivityTime(playerId); 
        
        return new ResponseEntity<String>(activityJson, headers, HttpStatus.CREATED);
    }      
    
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updatePlayerShallow(@RequestBody String json, Principal principal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Player player = Player.fromJsonToPlayer(json);
        log.info("user: "+principal.getName()+", method: updatePlayerShallow, playerId: "+player.getId());
        playerService.updatePlayerShallow(player) ;
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{id}/playlistsongs/{sid}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> destroyPlaylistSong(@PathVariable("id") ObjectId playerId, @PathVariable("sid") ObjectId songId) {	
		Song song = playerService.findSong(playerId,songId);
		
        playerService.destroyPlaylistSong(playerId, song);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        log.info("destroyPlaylistSong playerId: "+playerId+" deleted songId: "+songId);
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }	
    
////////////    
    

	@RequestMapping(value = "/{id}", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") ObjectId id) {
        Player player = playerService.findPlayer(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (player == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(player.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Player> result = playerService.findAllPlayers();
        return new ResponseEntity<String>(Player.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, Principal principal) {
        Player player = Player.fromJsonToPlayer(json);
        playerService.savePlayer(player);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        log.info("user: "+principal.getName()+", method: createFromJson, playerId: "+player.getId());
        
        playerService.updateLastActivityTime(player.getId());
        playerService.updateLastPolledTime(player.getId());
        
        return new ResponseEntity<String>("{\"id\": \""+player.getId()+"\"}",headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Player player: Player.fromJsonArrayToPlayers(json)) {
            playerService.savePlayer(player);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


	
	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json) {
		log.info("updateFromJson");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Player player = Player.fromJsonToPlayer(json);
        if (playerService.updatePlayer(player) == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJsonArray(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        for (Player player: Player.fromJsonArrayToPlayers(json)) {
            if (playerService.updatePlayer(player) == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") ObjectId id) {
        Player player = playerService.findPlayer(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (player == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        playerService.deletePlayer(player);
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@Autowired
    PlayerService playerService;

	@Autowired
    SongService songService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Player player, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, player);
            return "players/create";
        }
        uiModel.asMap().clear();
        playerService.savePlayer(player);
        return "redirect:/players/" + encodeUrlPathSegment(player.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Player());
        return "players/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") ObjectId id, Model uiModel) {
        uiModel.addAttribute("player", playerService.findPlayer(id));
        uiModel.addAttribute("itemId", id);
        return "players/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("players", playerService.findPlayerEntries(firstResult, sizeNo));
            float nrOfPages = (float) playerService.countAllPlayers() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("players", playerService.findAllPlayers());
        }
        return "players/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Player player, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, player);
            return "players/update";
        }
        uiModel.asMap().clear();
        playerService.updatePlayer(player);
        return "redirect:/players/" + encodeUrlPathSegment(player.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") ObjectId id, Model uiModel) {
        populateEditForm(uiModel, playerService.findPlayer(id));
        return "players/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") ObjectId id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Player player = playerService.findPlayer(id);
        playerService.deletePlayer(player);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/players";
    }

	void populateEditForm(Model uiModel, Player player) {
        uiModel.addAttribute("player", player);
        uiModel.addAttribute("songs", songService.findAllSongs());
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}

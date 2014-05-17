package in.mused.api.web;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import flexjson.JSONSerializer;
import in.mused.api.domain.User;
import in.mused.api.service.SecurityService;
import in.mused.api.service.UserService;
import in.mused.api.util.ObjectIdTransformer;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value={"/users","/api/users"})
@Controller
@RooWebScaffold(path = "users", formBackingObject = User.class)
@RooWebJson(jsonObject = User.class)
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SecurityService securityService;
	
    @RequestMapping(value = "/sync", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> syncUser(@RequestBody String appUserJson) {
    	User appUser = User.fromJsonToUser(appUserJson);
    	User user = userService.findUserByUsername(appUser.getUsername());
    	

    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        if(user==null){
        	user = new User();
			user.setUsername(appUser.getUsername());
			user.setEmail(appUser.getEmail());
			user.setPassword(securityService.encodePassword(appUser.getUsername(), "musedin", appUser.getUsername()));
			user.setAccountExpired(false);
			user.setAccountLocked(false);
			user.setPasswordExpired(false);
			user.setEnabled(true);
			user.setLocation(appUser.getLocation());
			user.setDisplayname(appUser.getDisplayname());
			user.setType(appUser.getType());
			
			Set<String> roles = new HashSet<String>();
			roles.add("ROLE_USER");
			user.setRoles(roles);
			
			Date now = new Date();
			user.setDateCreated(now);
			user.setLastUpdated(now);
			
			userService.saveUser(user);
        }
        
        JSONSerializer serializer = new JSONSerializer().transform(new ObjectIdTransformer(), org.bson.types.ObjectId.class);
        String json = serializer.exclude("*.class").serialize(user);
        
        return new ResponseEntity<String>(json, headers, HttpStatus.OK);

    }
}

package in.mused.api.social;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import in.mused.api.domain.User;
import in.mused.api.repository.UserRepository;
import in.mused.api.service.SecurityService;
import in.mused.api.service.UserService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserConnectionSignUp implements ConnectionSignUp {
    
    Logger log = LogManager.getLogger(UserConnectionSignUp.class);

    private final UserService userService;
    private final SecurityService securityService;
    
    @Inject
	public UserConnectionSignUp(UserService userService, SecurityService securityService) {
		this.userService = userService;
		this.securityService = securityService;
	}

    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        
        String displayName = profile.getName();
        if(displayName==null){
        	displayName = connection.getDisplayName();
        }
        
        User u = new User();
        u.setUsername(connection.getKey().toString().replaceAll(":", "#")+"#"+displayName);
        u.setDisplayname(displayName);
        u.setType("WEB");
        
        if(profile.getEmail()!=null){
        	u.setEmail(profile.getEmail());
        }
        else{
        	u.setEmail(connection.getDisplayName());
        }
		
		
		u.setPassword(securityService.encodePassword(u.getUsername(), "musedin", u.getUsername()));
		u.setAccountExpired(false);
		u.setAccountLocked(false);
		u.setPasswordExpired(false);
		u.setEnabled(true);
		//u.setLocation(new double[]{10.0,77.0});
		
		Set<String> roles = new HashSet<String>();
		roles.add("ROLE_USER");
		u.setRoles(roles);
		
		Date now = new Date();
		u.setDateCreated(now);
		u.setLastUpdated(now);
		
		userService.saveUser(u);
		
        
        return u.getUsername();
    }
	
}
package in.mused.api.util;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import in.mused.api.domain.User;
import in.mused.api.service.PlayerService;
import in.mused.api.service.UserService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	Logger log = LogManager.getLogger(Bootstrap.class);
	
	@Autowired
    UserService userService;
	
	@Autowired
    PlayerService playerService;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if (event.getApplicationContext().getParent() == null) {
			log.info("####################");
			log.info("MusedIn BootStrapping...");
			log.info("build-name: "+playerService.getBuildName());
			log.info("build-version : "+playerService.getBuildVersion());
			log.info("build-number : "+playerService.getBuildNumber());
			log.info("build-time : "+playerService.getBuildTime());
			log.info("build-env : "+playerService.getBuildEnv());
			//log.info("app-url : "+playerService.getAppUrl());
			log.info("app-path : "+playerService.getAppPath());
			log.info("server-info : "+playerService.getServerInfo());
			
			
			if(userService.countAllUsers()==0){
				User u1 = new User();
				u1.setUsername("info@mused.in");
				u1.setEmail("info@mused.in");
				//u1.setPassword("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");
				//u1.setPassword("39c15d264bc1602fc35056e05deaecd2");
				
				//info@mused.in#musedin#BobMarley1945
				u1.setPassword("7a4e9354366bf488f8126db0c05b5ed7");
				u1.setAccountExpired(false);
				u1.setAccountLocked(false);
				u1.setPasswordExpired(false);
				u1.setEnabled(true);
				u1.setLocation(new double[]{10.0,77.0});
				u1.setDisplayname("MusedIn Admin");
				u1.setType("ADMIN");
				
				Set<String> roles = new HashSet<String>();
				roles.add("ROLE_USER");
				u1.setRoles(roles);
				
				Date now = new Date();
				u1.setDateCreated(now);
				u1.setLastUpdated(now);
				
				userService.saveUser(u1);
			}
		}
	}
}
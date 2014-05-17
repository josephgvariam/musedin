package in.mused.api.social;

import java.util.ArrayList;
import java.util.List;

import in.mused.api.domain.User;
import in.mused.api.repository.UserRepository;
import in.mused.api.service.SecurityService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class SpringSecuritySignInAdapter implements SignInAdapter {
	
//    @Autowired
//    UserRepository userRepository;
    
    @Autowired
    SecurityService securityService;
    
    Logger log = LogManager.getLogger(SpringSecuritySignInAdapter.class);
    
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
    	log.debug("signIn called. localUserId = "+localUserId);
    	
    	UserDetails ud = securityService.loadUserByUsername(localUserId);
    	//User u = userRepository.findByUsername(localUserId);
    	
//    	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		for (String role : u.getRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role));
//		}
		
	    Authentication authentication = new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
	    SecurityContextHolder.getContext().setAuthentication(authentication);
    	
        return null;
    }
}

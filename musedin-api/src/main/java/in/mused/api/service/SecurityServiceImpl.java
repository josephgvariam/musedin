package in.mused.api.service;

import in.mused.api.domain.User;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.codec.Hex;

@Component
public class SecurityServiceImpl implements SecurityService {
	
	Logger log = LogManager.getLogger(SecurityServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		log.debug("Searching users. username: "+username+" User: "+u);
		if(u==null) throw new UsernameNotFoundException("Username not found: "+username);
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (String role : u.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), u.getEnabled(), !u.getAccountExpired(), !u.getAccountExpired(), !u.getAccountLocked(), authorities);
	}
	
	
//	public String encodePassword(final String rawPass, final Object salt) {
//		String username = salt.toString();
//		return md5Hex(username + ":" + "musedin" + ":" + rawPass);
//	}
//	
//	public boolean isPasswordValid(final String encPass, final String rawPass, final Object salt) {
//		// the 'raw' password will already be encrypted, so compare directly
//		return encPass != null && rawPass != null ? rawPass.equals(encPass) : false;
//	}
//	
//	private String md5Hex(final String s) {
//		MessageDigest digest;
//		try {
//			digest = MessageDigest.getInstance("MD5");
//		}
//		catch (NoSuchAlgorithmException e) {
//			throw new IllegalStateException("No MD5 algorithm available!");
//		}
//
//		return new String(Hex.encode(digest.digest(s.getBytes())));
//	}
	
	public String encodePassword(String username, String realm, String password) {
        String a1 = username + "#" + realm + "#" + password;
        return md5Hex(a1);
    }
	
	private String md5Hex(String data) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No MD5 algorithm available!");
        }

        return new String(Hex.encode(digest.digest(data.getBytes())));
    }

}

package in.mused.api.service;

import org.springframework.roo.addon.layers.service.RooService;
import org.springframework.security.core.userdetails.UserDetailsService;

@RooService(domainTypes = { in.mused.api.domain.User.class })
public interface SecurityService extends UserDetailsService{
	public String encodePassword(String username, String realm, String password);
}

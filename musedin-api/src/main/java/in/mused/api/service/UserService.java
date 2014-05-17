package in.mused.api.service;

import in.mused.api.domain.User;

import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { in.mused.api.domain.User.class })
public interface UserService {
	public User findUserByUsername(String username);
}

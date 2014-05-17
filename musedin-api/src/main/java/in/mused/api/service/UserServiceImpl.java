package in.mused.api.service;

import java.util.List;

import in.mused.api.domain.User;
import in.mused.api.repository.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserService {

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}

	

	
	
}

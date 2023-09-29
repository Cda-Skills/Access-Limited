package org.example.accesLimited.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.example.accesLimited.model.User;

@Service
public interface UserService {
	
	User saveUser(User user);
	
	User updateUser(User user);
	
	User getUser(Long id);
	
	List<User> getAllUsers();
	
	void deleteUserById(Long id);
	
	void deleteAllUsers();

}

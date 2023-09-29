package org.example.accesLimited.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.accesLimited.repository.UserRepository;
import org.example.accesLimited.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	public User getUser(Long id) {
		
		return userRepository.findById(id).get();
	}

	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	public void deleteUserById(Long id) {
		
		userRepository.deleteById(id);
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

}
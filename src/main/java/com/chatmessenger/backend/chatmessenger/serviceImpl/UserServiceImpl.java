package com.chatmessenger.backend.chatmessenger.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatmessenger.backend.chatmessenger.entity.User;
import com.chatmessenger.backend.chatmessenger.repository.UserRepository;
import com.chatmessenger.backend.chatmessenger.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUser(Long id) {
		return userRepository.findById(id)
				.map(user->user)
				.orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		if (user == null) {
			return null;
		}
		return userRepository.save(user);
	}

}

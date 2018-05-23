package com.chatmessenger.backend.chatmessenger.service;

import java.util.List;

import com.chatmessenger.backend.chatmessenger.entity.User;

public interface UserService {
	User getUser(Long id);
	List<User> getAllUsers();
	User saveUser(User user);
}

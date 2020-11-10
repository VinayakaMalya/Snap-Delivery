package com.snapdelivery.service;

import org.springframework.http.ResponseEntity;

import com.snapdelivery.model.User;

public interface UserService {

	User findByUserId(Integer userId);

	User registerUser(User user);

	ResponseEntity<User> loginUser(User user);

}

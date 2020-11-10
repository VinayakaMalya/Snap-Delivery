package com.snapdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snapdelivery.model.User;
import com.snapdelivery.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/registerUser")
	public User registerUser(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
	
	@PostMapping("/user/loginUser")
	public ResponseEntity<User> loginUser(@RequestBody User user)
	{
		return userService.loginUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public User findByUserId(@PathVariable("userId") Integer userId)
	{
		User user = userService.findByUserId(userId);
		if(user!=null)
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	
}

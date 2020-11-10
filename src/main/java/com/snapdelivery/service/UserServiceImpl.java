package com.snapdelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.snapdelivery.model.User;
import com.snapdelivery.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User findByUserId(Integer userId) 
	{
		User usernow = userRepository.findByUserId(userId);
		if(usernow!=null)
		{
			return usernow;
		}
		else
		{
			return null;
		}
	}

	@Override
	public User registerUser(User user) 
	{
		return userRepository.save(user);
	}

	@Override
	public ResponseEntity<User> loginUser(User user) 
	{
		User usernow = userRepository.findByEmailId(user.getEmailId());
		if(usernow!=null)
		{
			if(usernow.getEmailId().equalsIgnoreCase(user.getEmailId()) &&
					usernow.getPassword().equalsIgnoreCase(user.getPassword()))
			{
				return new ResponseEntity<>(usernow,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	}
	
}

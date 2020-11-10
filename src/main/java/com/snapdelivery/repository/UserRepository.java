package com.snapdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snapdelivery.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{

	User findByUserId(Integer userId);

	User findByEmailId(String emailId);

}

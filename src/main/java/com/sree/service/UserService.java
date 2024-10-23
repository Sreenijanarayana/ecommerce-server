package com.sree.service;

import java.util.List;

import com.sree.model.User;

import com.sree.exception.UserException;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public List<User> findAllUsers();


}

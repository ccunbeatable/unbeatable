package com.containercrush.unbeatable.service;


import java.util.List;

import com.containercrush.unbeatable.exceptions.UserAlreadyExistsException;
import com.containercrush.unbeatable.exceptions.UserNotFoundException;
import com.containercrush.unbeatable.model.User;

public interface UserService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

	Object registerUser(User user) throws UserAlreadyExistsException;

	Object updateUser(String id ,User user) throws UserNotFoundException;

	void deleteUser(String id) throws UserNotFoundException;

	Object getUserById(String userId) throws UserNotFoundException;

	List<User> getAllUsers() throws UserNotFoundException;

	User findById(String id);

}

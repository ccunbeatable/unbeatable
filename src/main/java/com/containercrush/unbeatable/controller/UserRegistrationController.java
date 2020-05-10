package com.containercrush.unbeatable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.containercrush.unbeatable.exceptions.UserAlreadyExistsException;
import com.containercrush.unbeatable.exceptions.UserNotFoundException;
import com.containercrush.unbeatable.model.ApiResponse;
import com.containercrush.unbeatable.model.User;
import com.containercrush.unbeatable.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/users")
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ApiResponse registerUser(@RequestBody User user) throws UserAlreadyExistsException {
		return new ApiResponse(HttpStatus.OK.value(), "User saved successfully.",userService.registerUser(user));
	}

	@GetMapping
	public ApiResponse getAllUsers() throws UserNotFoundException {
		return new ApiResponse(HttpStatus.OK.value(), "User list fetched successfully.",userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ApiResponse getUserById(@PathVariable String id) throws UserNotFoundException{
		return new ApiResponse(HttpStatus.OK.value(),"User fetched successfully.",userService.getUserById(id));
	}

	@PutMapping("/{id}")
	public ApiResponse updateUser(@PathVariable("id") String id , @RequestBody User user) throws UserNotFoundException {
		return  new ApiResponse(HttpStatus.OK.value(), "User updated successfully.",userService.updateUser(id ,user));
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse deleteUser(@PathVariable("id") String id) throws UserNotFoundException {
		System.out.println("userID:" + id);
		userService.deleteUser(id);
		return new ApiResponse(HttpStatus.OK.value(),"User deleted successfully.",null);
	}
}

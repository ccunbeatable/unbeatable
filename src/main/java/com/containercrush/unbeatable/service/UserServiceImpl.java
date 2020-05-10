package com.containercrush.unbeatable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.containercrush.unbeatable.exceptions.UserAlreadyExistsException;
import com.containercrush.unbeatable.exceptions.UserNotFoundException;
import com.containercrush.unbeatable.model.User;
import com.containercrush.unbeatable.repository.UserRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	/*
	 * Autowiring should be implemented for the UserRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	/*
	 * This method should be used to save a new user.Call the corresponding method
	 * of Respository interface.
	 */
	@Override
	public User registerUser(User user) throws UserAlreadyExistsException {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		return userRepository.findAll();
	}

	/*
	 * This method should be used to get a user by userId.Call the corresponding
	 * method of Respository interface.
	 */

	public User getUserById(String userId) throws UserNotFoundException {
		Optional optionalUser = userRepository.findById(userId);
		return optionalUser.isPresent() ? (User) optionalUser.get() : null;
	}

	/*
	 * This method should be used to update a existing user.Call the corresponding
	 * method of Respository interface.
	 */

	public User updateUser(String id, User user) throws UserNotFoundException {
		System.out.println("userId::" + id);
		User userUpdated = findById(id);
		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		Optional<User> optionalUser = userRepository.findById(id.toString());
		System.out.println("optionalUser::" + optionalUser);
		return optionalUser.isPresent() ? (User) optionalUser.get() : null;
	}

	/*
	 * This method should be used to delete an existing user. Call the corresponding
	 * method of Respository interface.
	 */

	public void deleteUser(String id) throws UserNotFoundException {
		userRepository.deleteById(id);
	}

}

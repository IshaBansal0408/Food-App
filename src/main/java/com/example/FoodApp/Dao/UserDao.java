package com.example.FoodApp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FoodApp.Models.User;
import com.example.FoodApp.Repository.UserRepository;

public class UserDao {

    @Autowired
	UserRepository userRepository;

//	1. Create a new User
	public User addUser(User user) {
		return userRepository.save(user);
	}

//	2. Read a particular Users
	public User getUserById(int id) {
		return userRepository.findById(id);
	}

//	3. Update a user
	public User updateUser(int id, User user) {
		user.setId(id);
		userRepository.save(user);
		return user;
	}

//	4. Delete a user
	public User deleteUser(int id) {
		User u = userRepository.findById(id);
		userRepository.delete(u);
		return u;
	}

//	5. Read all users
	public List<User> getAllUsers() {
		List<User> allUsers = (List<User>) userRepository.findAll();
		return allUsers;
	}

}

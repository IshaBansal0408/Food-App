package com.example.FoodApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApp.Dao.UserDao;
import com.example.FoodApp.Models.User;
import com.example.FoodApp.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setError(false);
		structure.setMessage(user.getName() + "saved");
		structure.setData(userDao.addUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
}

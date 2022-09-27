package com.example.FoodApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApp.Dao.UserDao;
import com.example.FoodApp.Models.Menu;
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
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id){
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> optional = userDao.getUserById(id);
		if(optional.isEmpty()) {
			System.out.println("No such id is found");
		}
		else {
			structure.setError(false);
			structure.setMessage("User Found");
			structure.setData(optional.get());
		}
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getAllStaffs(){
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
			structure.setError(false);
			structure.setMessage("User Found");
			structure.setData(userDao.getAllStaff());
		
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> login(String email, String password){
		ResponseStructure<User> structure = new ResponseStructure<>();
		User user = userDao.loginUser(email, password);
		if(user!=null) {
			structure.setError(false);
			structure.setMessage("Login Successful");
			structure.setData(user);
		}else {
			structure.setError(true);
			structure.setMessage("Invalid credentials");
			structure.setData(user);
		}
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){	
		ResponseStructure<User> structure = new ResponseStructure<>();
		int existingUserId = user.getId();
		User existingUser = userDao.getUserById(existingUserId).get();
		Menu menu = existingUser.getMenu();
		    user.setMenu(menu);
			structure.setError(false);
			structure.setMessage("Updated Successfully");
			structure.setData(userDao.updateUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> optional = userDao.getUserById(id);
		if(optional.isEmpty()) {
			structure.setError(true);
			structure.setMessage("No user with that id");
		}else {
			structure.setError(false);
			structure.setMessage("User Deleted");
			userDao.deleteUser(optional.get());
		}
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}
	
}

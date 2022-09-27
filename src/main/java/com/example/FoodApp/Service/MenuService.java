package com.example.FoodApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApp.Dao.MenuDao;
import com.example.FoodApp.Dao.UserDao;
import com.example.FoodApp.Models.Menu;
import com.example.FoodApp.Models.User;
import com.example.FoodApp.util.ResponseStructure;

@Service
public class MenuService {
	
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	UserDao userDao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu, int id){
		Optional<User> optional = userDao.getUserById(id);
		ResponseStructure<Menu> structure = new ResponseStructure<>();

		Menu menu1 = optional.get().getMenu();
		
		if(optional.isEmpty() ) {
			structure.setError(true);
			structure.setMessage("No id found");
		}else if (menu1!=null) {
			structure.setError(true);
			structure.setMessage("Hey a manager can have only 1 menu");
		}
		else {
				menu.setUser(optional.get());
				structure.setError(false);
				structure.setMessage("Menu saved");
				structure.setData(menuDao.addMenu(menu));
		}
		return new ResponseEntity<ResponseStructure<Menu>> (structure, HttpStatus.OK) ;	
	}
	
	public ResponseEntity<ResponseStructure<Menu>> getMenuByManagerId(int managerId){
		ResponseStructure<Menu> structure = new ResponseStructure<>();
		structure.setError(false);
		structure.setMessage("Menu retrived");
		structure.setData(menuDao.getMenuByManagerId(managerId));		
		return new ResponseEntity<ResponseStructure<Menu>> (structure, HttpStatus.OK) ;	
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteMenu(int id){
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Menu> optional = menuDao.getMenuById(id);
		if(optional.isEmpty()) {
			structure.setError(true);
			structure.setMessage("No menu with that id");
		}else {
			structure.setError(false);
			structure.setMessage("Menu Deleted");
			menuDao.deleteMenu(id);
	}
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

}

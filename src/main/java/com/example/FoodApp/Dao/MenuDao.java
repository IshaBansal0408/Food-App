package com.example.FoodApp.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.FoodApp.Models.Menu;
import com.example.FoodApp.Repository.MenuRepository;

@Repository
public class MenuDao {
	
	@Autowired
	MenuRepository menuRepository;
	
	public Menu addMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public Optional<Menu> getMenuById(int id) {
		return menuRepository.findById(id);
	}
	
	public void deleteMenu(int id) {
		menuRepository.deleteById(id);
	}
	
}

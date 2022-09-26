package com.example.FoodApp.Models;

import java.util.List;

public class Menu {

	private int id;
	
	List<FoodProduct> foodProducts;
	User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

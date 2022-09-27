package com.example.FoodApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.FoodApp.Models.FoodProduct;
import com.example.FoodApp.Repository.FoodProductRepository;

@Repository
public class FoodProductDao {
	
	@Autowired
	FoodProductRepository foodProductRepository;
	
	public FoodProduct addFoodProduct(FoodProduct foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
	
	public Optional<FoodProduct> getFoodProductById(int id) {
		return foodProductRepository.findById(id);
	}
	
	public List<FoodProduct> getAllFoodProducts() {
		return foodProductRepository.findAll();
	}
	
	public void deleteFoodProduct(int id) {
		foodProductRepository.deleteById(id);
	}

}

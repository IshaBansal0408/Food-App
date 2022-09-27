package com.example.FoodApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.FoodApp.Models.FoodOrder;
import com.example.FoodApp.Repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	
	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	public FoodOrder addFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	
	public Optional<FoodOrder> getFoodOrderById(int id) {
		return foodOrderRepository.findById(id);
	}
	
	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderRepository.findAll();
	}
	
	public FoodOrder updateFoodOrder(int id, FoodOrder foodOrder) {
		foodOrder.setId(id);
		foodOrderRepository.save(foodOrder);
		return foodOrder;
	}
	
	public void deleteFoodOrder(int id) {
		foodOrderRepository.deleteById(id);
	}

}

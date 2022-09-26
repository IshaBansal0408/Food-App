package com.example.FoodApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApp.Models.FoodProduct;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Integer> {

}

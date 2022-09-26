package com.example.FoodApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApp.Models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}

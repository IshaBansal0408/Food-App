package com.example.FoodApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApp.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(int id);
}

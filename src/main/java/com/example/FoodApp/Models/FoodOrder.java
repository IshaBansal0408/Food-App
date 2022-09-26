package com.example.FoodApp.Models;

import java.util.Date;

public class FoodOrder {

	private int id;
	private boolean status;
	private double totalPrice;
	private Date orderCreatedTime;
	private Date orderDeliveryTime;
	private String customerName;
	private long contactNumber;
	
	User user;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Date getOrderCreatedTime() {
		return orderCreatedTime;
	}
	
	public void setOrderCreatedTime(Date orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}
	
	public Date getOrderDeliveryTime() {
		return orderDeliveryTime;
	}
	
	public void setOrderDeliveryTime(Date orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public long getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
}

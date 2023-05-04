package com.emart.test.service;

import java.util.List;

import com.emart.test.entity.Orders;

public interface OrdersService {

	Orders createOrders(Orders orders);
	
	Orders updateOrders(Orders orders, Integer ordersId);
	
	Orders getOrdersById(Integer ordersId);
	
	List<Orders> getAllOrders();
	
	void deleteOrders(Integer ordersId);
	
}

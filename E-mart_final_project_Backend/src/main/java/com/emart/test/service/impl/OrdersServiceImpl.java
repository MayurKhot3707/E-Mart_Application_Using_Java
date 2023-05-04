package com.emart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.entity.Orders;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.OrdersRepository;
import com.emart.test.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	
	@Autowired
	private OrdersRepository ordersRepository;
	
	
	@Override
	public Orders createOrders(Orders orders) {
		
		return this.ordersRepository.save(orders);
	}

	@Override
	public Orders updateOrders(Orders orders, Integer ordersId) {
		Orders order = this.ordersRepository.findById(ordersId)
				.orElseThrow(()->new ResourceNotFoundException("Ordres","ordersId",ordersId));
		order.setProductname(orders.getProductname());
		return order;
	}

	@Override
	public Orders getOrdersById(Integer ordersId) {
		Orders order = this.ordersRepository.findById(ordersId)
				.orElseThrow(()->new ResourceNotFoundException("Ordres","ordersId",ordersId));
		return order;
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> ordersList = this.ordersRepository.findAll();
		return ordersList;
	}

	@Override
	public void deleteOrders(Integer ordersId) {
		Orders order = this.ordersRepository.findById(ordersId)
				.orElseThrow(()->new ResourceNotFoundException("Ordres","ordersId",ordersId));
		this.ordersRepository.delete(order);
	}

}

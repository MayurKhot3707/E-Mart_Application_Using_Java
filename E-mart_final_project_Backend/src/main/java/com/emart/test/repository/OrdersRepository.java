package com.emart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.test.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer>{

}

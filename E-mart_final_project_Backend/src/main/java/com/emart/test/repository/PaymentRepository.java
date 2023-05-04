package com.emart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.test.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}

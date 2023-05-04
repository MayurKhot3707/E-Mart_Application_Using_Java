package com.emart.test.service;

import java.util.List;

import com.emart.test.entity.Payment;

public interface PaymentService {

	Payment createPayment(Payment payment);
	
	Payment updatePayment(Payment payment, Integer paymentId);
	
	Payment getPaymentById(Integer paymentId);
	
	List<Payment> getAllPayments();
	
	void deletePayment(Integer paymentid);
}

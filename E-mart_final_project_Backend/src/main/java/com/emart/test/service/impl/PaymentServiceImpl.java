package com.emart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.test.entity.Payment;
import com.emart.test.exception.ResourceNotFoundException;
import com.emart.test.repository.PaymentRepository;
import com.emart.test.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment createPayment(Payment payment) {
		
		return this.paymentRepository.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment, Integer paymentId) {
		Payment payment1 = this.paymentRepository.findById(paymentId)
				.orElseThrow(()-> new ResourceNotFoundException("Payment","paymentId",paymentId));
		payment1.setPaymentmode(payment.getPaymentmode());
		payment1.setPaymenttype(payment.getPaymenttype());
		return payment1;
	}

	@Override
	public Payment getPaymentById(Integer paymentId) {
		Payment payment1 = this.paymentRepository.findById(paymentId)
				.orElseThrow(()-> new ResourceNotFoundException("Payment","paymentId",paymentId));
		return payment1;
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> paymentList=this.paymentRepository.findAll();
		return paymentList;
	}

	@Override
	public void deletePayment(Integer paymentId) {
		Payment payment1 = this.paymentRepository.findById(paymentId)
				.orElseThrow(()-> new ResourceNotFoundException("Payment","paymentId",paymentId));
		this.paymentRepository.delete(payment1);
	}

}

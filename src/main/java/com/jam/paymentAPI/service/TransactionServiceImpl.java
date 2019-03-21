package com.jam.paymentAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.paymentAPI.entity.Customer;
import com.jam.paymentAPI.model.OrderRequest;
import com.jam.paymentAPI.model.OrderResponse;
import com.jam.paymentAPI.model.OrderResponse.Status;
import com.jam.paymentAPI.repository.CustomerRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public OrderResponse checkOrder(OrderRequest orderRequest) {
		//==============
		Optional<Customer> customer = customerRepository.findById(orderRequest.getCustId());
		Status answer = Status.ORDER_NOT_ACCEPTED; //rejected by default
		if(customer.isPresent()) {
		   if(  orderRequest.getPrice() <= customer.get().getFunds()) {
			answer = Status.ORDER_ACCEPTED; // accepted
		    }
		}  
		return new OrderResponse(answer); //reply for the answer
	}
	
	

}

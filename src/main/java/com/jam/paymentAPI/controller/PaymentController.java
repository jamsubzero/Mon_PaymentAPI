package com.jam.paymentAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jam.paymentAPI.entity.Customer;
import com.jam.paymentAPI.model.OrderRequest;
import com.jam.paymentAPI.model.OrderResponse;
import com.jam.paymentAPI.model.OrderResponse.Status;
import com.jam.paymentAPI.service.CustomerService;
import com.jam.paymentAPI.service.TransactionService;

@RequestMapping("/paymentapi")
@RestController
public class PaymentController {

@Autowired
TransactionService transactionServiceImpl;

@Autowired
CustomerService customerServiceImpl;

@PostMapping("/checkorder")
public OrderResponse checkOrder(@RequestBody OrderRequest orderRequest){
	Customer customer = customerServiceImpl.getCustomerById(orderRequest.getCustId()).get();
	Status answer = Status.ORDER_NOT_ACCEPTED; //rejected by default
	if(  orderRequest.getPrice() <= customer.getFunds()) {
		answer = Status.ORDER_ACCEPTED; // accepted
	}
	return new OrderResponse(answer); //reply for the answer
}
	
	
}

package com.jam.paymentAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jam.paymentAPI.model.OrderRequest;
import com.jam.paymentAPI.model.OrderResponse;
import com.jam.paymentAPI.service.TransactionService;

@RequestMapping("/paymentapi")
@RestController
public class PaymentController {

@Autowired
TransactionService transactionServiceImpl;

@PostMapping("/checkorder")
public OrderResponse checkOrder(@RequestBody OrderRequest orderRequest){
   return transactionServiceImpl.checkOrder(orderRequest);	
}
	
	
}

package com.jam.paymentAPI.service;

import com.jam.paymentAPI.model.OrderRequest;
import com.jam.paymentAPI.model.OrderResponse;

public interface TransactionService {

	OrderResponse checkOrder(OrderRequest orderRequest);
}

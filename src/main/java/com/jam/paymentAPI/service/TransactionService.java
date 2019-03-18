package com.jam.paymentAPI.service;

import java.util.List;
import java.util.Optional;

import com.jam.paymentAPI.entity.Customer;
import com.jam.paymentAPI.entity.Transaction;

public interface TransactionService {

	List<Transaction> findTransactionsByCustomer(Customer customer); //in case the customer object is available
	Optional<Transaction> findTransactionById(int transId); //when the client has the transaction id
	Transaction createNewTransaction(Transaction transaction);
}

package com.jam.paymentAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.paymentAPI.entity.Customer;
import com.jam.paymentAPI.entity.Transaction;
import com.jam.paymentAPI.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Transaction> findTransactionsByCustomer(Customer customer) {
		return transactionRepository.findTransactionsByCustomer(customer);
	}

	@Override
	public Optional<Transaction> findTransactionById(int transid) {
		return transactionRepository.findById(transid);
	}

	@Override
	public Transaction createNewTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	

}

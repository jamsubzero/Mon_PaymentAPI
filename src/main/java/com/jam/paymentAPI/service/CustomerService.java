package com.jam.paymentAPI.service;


import java.util.Optional;

import com.jam.paymentAPI.entity.Customer;

public interface CustomerService {

	Optional<Customer> getCustomerById(int custid);
	Customer addOrUpdateCustomer(Customer customer);
}

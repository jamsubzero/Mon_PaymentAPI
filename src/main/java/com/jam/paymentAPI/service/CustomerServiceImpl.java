package com.jam.paymentAPI.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.paymentAPI.entity.Customer;
import com.jam.paymentAPI.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
 

	@Override
	public Optional<Customer> getCustomerById(int custid) {
		return customerRepository.findById(custid);
	}

	@Override
	public Customer addOrUpdateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}

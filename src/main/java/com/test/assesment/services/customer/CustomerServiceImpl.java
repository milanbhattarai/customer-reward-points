package com.test.assesment.services.customer;

import com.test.assesment.entity.Customer;
import com.test.assesment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }


    public Customer getCustomerById(Long id) {
        return customerRepository.getById(id);
    }



}

package com.test.assesment.services.customer;

import com.test.assesment.entity.Customer;


import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer);
    //Customer getCustomerById(Long id);

}

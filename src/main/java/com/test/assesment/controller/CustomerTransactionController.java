package com.test.assesment.controller;

import com.test.assesment.entity.TransactionCust;
import com.test.assesment.services.customer.CustomerServiceImpl;
import com.test.assesment.services.transaction.CustomerTransactionImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-transactions")
public class CustomerTransactionController {
    @Autowired
    CustomerTransactionImplementation customerTransactionImpl;

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping
    public List<TransactionCust> getAllTransaction() {
        return customerTransactionImpl.findAllCustomerTransaction();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public TransactionCust saveTransaction(@RequestBody TransactionCust transaction) {
        transaction.setCustomer(customerService.getCustomerById(transaction.getCustomer().getId()));
        return customerTransactionImpl.saveCustomerTransaction(transaction);
    }

}

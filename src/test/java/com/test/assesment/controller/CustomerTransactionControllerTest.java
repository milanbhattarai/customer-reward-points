package com.test.assesment.controller;

import com.test.assesment.entity.Customer;
import com.test.assesment.entity.TransactionCust;
import com.test.assesment.services.customer.CustomerServiceImpl;
import com.test.assesment.services.transaction.CustomerTransactionImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTransactionControllerTest {
    @InjectMocks
    CustomerTransactionController controller;

    @Mock
    CustomerTransactionImplementation customerTransactionImpl;

    @Mock
    CustomerServiceImpl customerService;

    @Test
    public void testGetAllTransaction() {
        when(customerTransactionImpl.findAllCustomerTransaction()).thenReturn(Arrays.asList(new TransactionCust(), new TransactionCust()));
        assertEquals(2, controller.getAllTransaction().size());
        verify(customerTransactionImpl, times(1)).findAllCustomerTransaction();
    }

    @Test
    public void testSaveTransaction() {
        TransactionCust transaction = new TransactionCust();
        Customer customer = new Customer();
        customer.setId(1L);
        transaction.setCustomer(customer);

        when(customerService.getCustomerById(1L)).thenReturn(customer);
        when(customerTransactionImpl.saveCustomerTransaction(transaction)).thenReturn(transaction);

        assertEquals(transaction, controller.saveTransaction(transaction));
        verify(customerService, times(1)).getCustomerById(1L);
        verify(customerTransactionImpl, times(1)).saveCustomerTransaction(transaction);
    }
}

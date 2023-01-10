package com.test.assesment.services.customer;

import com.test.assesment.entity.Customer;
import com.test.assesment.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    @InjectMocks
    CustomerServiceImpl service;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomer() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(new Customer(), new Customer()));
        assertEquals(2, service.getAllCustomer().size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer, service.saveCustomer(customer));
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testGetCustomerById() {
        Long id = 1L;
        Customer customer = new Customer();
        when(customerRepository.getById(id)).thenReturn(customer);
        assertEquals(customer, service.getCustomerById(id));
        verify(customerRepository, times(1)).getById(id);
    }
}

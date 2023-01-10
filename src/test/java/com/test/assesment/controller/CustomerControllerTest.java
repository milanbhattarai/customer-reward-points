package com.test.assesment.controller;

import com.test.assesment.entity.Customer;
import com.test.assesment.services.customer.CustomerService;
import com.test.assesment.services.transaction.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
    @InjectMocks
    CustomerController controller;

    @Mock
    CustomerService customerService;

    @Mock
    TransactionService transactionService;

    @Test
    public void testGetAllCustomer() {
        when(customerService.getAllCustomer()).thenReturn(Arrays.asList(new Customer(), new Customer()));
        assertEquals(2, controller.getAllCustomer().size());
        verify(customerService, times(1)).getAllCustomer();
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        when(customerService.saveCustomer(customer)).thenReturn(customer);
        assertEquals(customer, controller.createCustomer(customer));
        verify(customerService, times(1)).saveCustomer(customer);
    }

    @Test
    public void testGetTotalRewardsForCustomer() {
        Long id = 1L;
        Map<String, Long> rewards = new HashMap<>();
        when(transactionService.getTotalRewardPointForCustomer(id)).thenReturn(rewards);
        assertEquals(rewards, controller.getTotalRewardsForCustomer(id));
        verify(transactionService, times(1)).getTotalRewardPointForCustomer(id);
    }

    @Test
    public void testGetMonthlyUserReward() throws SQLException {
        Long id = 1L;
        List<Object> rewards = Arrays.asList(new Object(), new Object());
        when(transactionService.getRewardPointPerMonth(id)).thenReturn(rewards);
        assertEquals(rewards, controller.getMonthlyUserReward(id));
        verify(transactionService, times(1)).getRewardPointPerMonth(id);
    }
}

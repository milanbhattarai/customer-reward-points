package com.test.assesment.services.transaction;

import com.test.assesment.entity.TransactionCust;
import com.test.assesment.repository.TransactionCustRepository;
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
public class CustomerTransactionImplementationTest {
    @InjectMocks
    CustomerTransactionImplementation service;

    @Mock
    TransactionCustRepository customerTransactionRepository;

    @Test
    public void testFindAllCustomerTransaction() {
        when(customerTransactionRepository.findAll()).thenReturn(Arrays.asList(new TransactionCust(), new TransactionCust()));
        assertEquals(2, service.findAllCustomerTransaction().size());
        verify(customerTransactionRepository, times(1)).findAll();
    }

    @Test
    public void testGetTotalRewardPointForCustomer() {
        Long id = 1L;
        Map<String, Long> rewards = new HashMap<>();
        when(customerTransactionRepository.getTotalRewardPointForCustomer(id)).thenReturn(100L);
        assertEquals(100L, (long) service.getTotalRewardPointForCustomer(id).get("totalReward"));
        verify(customerTransactionRepository, times(1)).getTotalRewardPointForCustomer(id);
    }

    @Test
    public void testGetRewardPointPerMonth() throws SQLException {
        Long id = 1L;
        List<Object> rewards = Arrays.asList(new Object(), new Object());
        when(customerTransactionRepository.getMonthlyUserRewards(id)).thenReturn(rewards);
        assertEquals(rewards, service.getRewardPointPerMonth(id));
        verify(customerTransactionRepository, times(1)).getMonthlyUserRewards(id);
    }
}

package com.test.assesment.services.transaction;

import com.test.assesment.entity.TransactionCust;
import com.test.assesment.repository.TransactionCustRepository;
import com.test.assesment.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerTransactionImplementation implements TransactionService {

    @Autowired
    TransactionCustRepository customerTransactionRepository;

    @Override
    public List<TransactionCust> findAllCustomerTransaction() {
        return customerTransactionRepository.findAll();
    }



    @Override
    public TransactionCust saveCustomerTransaction(TransactionCust transaction) {
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDateTime.now());
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime transactionDate = LocalDateTime.parse(String.valueOf(transaction.getTransactionDate()).replace("T", " "), formatter);
            transaction.setTransactionDate(transactionDate);
        }
        transaction.setRewardPerTransaction(Utils.calculateRewardPoint(transaction.getAmount()));
        return customerTransactionRepository.save(transaction);
    }

    @Override
    public Map<String, Long> getTotalRewardPointForCustomer(Long id) {
        Map<String, Long> totalReward = new HashMap<>();
        totalReward.put("customerId", id);
        totalReward.put("totalReward", customerTransactionRepository.getTotalRewardPointForCustomer(id));

        return totalReward;
    }


    public List<Object> getRewardPointPerMonth(Long id) throws SQLException {
        return customerTransactionRepository.getMonthlyUserRewards(id);

    }
}

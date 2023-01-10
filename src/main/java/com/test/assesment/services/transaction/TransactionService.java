package com.test.assesment.services.transaction;

import com.test.assesment.entity.TransactionCust;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TransactionService {
    List<TransactionCust> findAllCustomerTransaction();

    TransactionCust saveCustomerTransaction(TransactionCust transaction);


    Map<String, Long> getTotalRewardPointForCustomer(Long id);
    List<Object>getRewardPointPerMonth(Long id) throws SQLException;
}

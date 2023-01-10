package com.test.assesment.repository;

import com.test.assesment.entity.TransactionCust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;

public interface TransactionCustRepository extends JpaRepository<TransactionCust, Long> {
    @Query(nativeQuery = true,
            value = "SELECT SUM(reward_per_transaction) " +
                    "FROM transaction t where t.customer_id= :id")
    Long getTotalRewardPointForCustomer(@Param("id") Long id);

    @Query(
            value = "SELECT new com.test.assesment.util.MonthlyReport(t.customer.id, " +
                    "SUM(t.rewardPerTransaction)," +
                    "MONTH(t.transactionDate), YEAR(t.transactionDate)) " +
                    " FROM TransactionCust t" +
                    " WHERE t.customer.id = :id  GROUP BY MONTH(t.transactionDate) , YEAR(t.transactionDate) , t.customer.id")
    List<Object> getMonthlyUserRewards(@Param("id") Long id) throws SQLException;

}



package com.test.assesment.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyReport implements Serializable {
    private Long customerId;
    private Long totalReward;
    private int monthOfTransaction;
    private int yearOfTransaction;

}
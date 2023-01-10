package com.test.assesment.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    public void testCalculateRewardPoint() {
        // Test amount less than 50
        assertEquals(0, Utils.calculateRewardPoint(30L));
        assertEquals(0, Utils.calculateRewardPoint(49L));

        // Test amount between 50 and 100
        assertEquals(0, Utils.calculateRewardPoint(50L));
        assertEquals(49, Utils.calculateRewardPoint(99L));

        // Test amount greater than 100
        assertEquals(150, Utils.calculateRewardPoint(150L));
        assertEquals(250, Utils.calculateRewardPoint(200L));
    }

}
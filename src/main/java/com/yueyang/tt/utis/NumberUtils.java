package com.yueyang.tt.utis;

import java.math.BigDecimal;

public class NumberUtils {

    public static double calculatePercent(double count, double total) {
        if (Math.abs(count) < 0.001D) {
            return 0.0D;
        } else if (Math.abs(total) < 0.01D) {
            return 100.0D;
        } else {
            BigDecimal b1 = new BigDecimal(count);
            BigDecimal b2 = new BigDecimal(total);
            BigDecimal result = b1.divide(b2, 4, 4).multiply(new BigDecimal(100));
            return result.doubleValue();
        }
    }

}

package dev.ajdinkomic.textanalyzer.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Helper {

    /**
     * Casts the (long) parameter value in nanoseconds to (double).
     * Divides the (double) value by 1000000 to get the number of milliseconds.
     * Converts the result of division to (BigDecimal).
     * Rounds the (BigDecimal) value to 3 decimal places using HALF_UP rounding mode and returns the result.
     *
     * @param nsLongValue value in nanoseconds
     * @return value in milliseconds
     */
    public static BigDecimal roundToThreeDecimalPlaces(long nsLongValue) {
        double msDoubleValue = ((double) nsLongValue / 1000000);
        BigDecimal msBigDecimalValue = BigDecimal.valueOf(msDoubleValue);
        msBigDecimalValue = msBigDecimalValue.setScale(3, RoundingMode.HALF_UP);

        return msBigDecimalValue;
    }
}

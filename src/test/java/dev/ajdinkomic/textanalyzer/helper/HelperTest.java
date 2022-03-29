package dev.ajdinkomic.textanalyzer.helper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperTest {

    @Test
    void shouldRoundPositiveNumberToThreeDecimalPlaces() {
        long longValue = 2500000;
        BigDecimal expectedValue = BigDecimal.valueOf(2.500);

        BigDecimal actualValue = Helper.roundToThreeDecimalPlaces(longValue);

        assertEquals(0, expectedValue.compareTo(actualValue));
    }

    @Test
    void shouldRoundNegativeNumberToThreeDecimalPlaces() {
        long longValue = -2500000;
        BigDecimal expectedValue = BigDecimal.valueOf(-2.500);

        BigDecimal actualValue = Helper.roundToThreeDecimalPlaces(longValue);

        assertEquals(0, expectedValue.compareTo(actualValue));
    }

    @Test
    void shouldRoundZeroToThreeDecimalPlaces() {
        long longValue = 0;
        BigDecimal expectedValue = BigDecimal.valueOf(0.000);

        BigDecimal actualValue = Helper.roundToThreeDecimalPlaces(longValue);

        assertEquals(0, expectedValue.compareTo(actualValue));
    }
}

package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTestConditionCov {
    @Test
    void testNLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
    }

    @Test
    void testNGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testNEqualsValue() {
        assertEquals("M", RomanNumeral.toRoman(1000));
    }

}
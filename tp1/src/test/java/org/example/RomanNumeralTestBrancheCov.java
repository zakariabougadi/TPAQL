package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTestBrancheCov {
    @Test
    void testLessThanOneThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    @Test
    void testGreaterThan3999ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testSingleIteration() {
        assertEquals("I", RomanNumeral.toRoman(1));
    }

    @Test
    void testMultipleIterations() {
        assertEquals("III", RomanNumeral.toRoman(3));
    }
}
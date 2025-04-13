package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTestLineCov {
    @Test
    void testInvalidNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testSingleSymbol() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("V", RomanNumeral.toRoman(5));
    }

    @Test
    void testSubtractiveNotation() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
    }

    @Test
    void testComplexNumber() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }
}
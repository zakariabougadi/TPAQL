package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTestConditionCov {
    @Test
    void testNLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
    }

    @Test
    void testDivisibleByFifteen() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    @Test
    void testDivisibleByThreeOnly() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    void testDivisibleByFiveOnly() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    @Test
    void testNotDivisible() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
}
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTestBrancheCov {
    @Test
    void testLessThanOneThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
    }

    @Test
    void testFizzBuzzBranch() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    void testFizzBranch() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    void testBuzzBranch() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testDefaultBranch() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
    }
}
package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciShouldReturn0ForN0() {
        assertEquals(0, Fibonacci.fibonacci(0));
    }

    @Test
    void fibonacciShouldReturn1ForN1() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void fibonacciShouldReturn5ForN5() {
        assertEquals(5, Fibonacci.fibonacci(5));
    }

    @Test
    void fibonacciShouldReturn55ForN10() {
        assertEquals(55, Fibonacci.fibonacci(10));
    }

    @Test
    void fibonacciShouldThrowExceptionForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }
}

package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void shouldReturnFalseForNumbersLessThan2() {
        assertFalse(Prime.isPrime(-10));
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
    }

    @Test
    void shouldReturnTrueForPrimeNumbers() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(7));
        assertTrue(Prime.isPrime(13));
        assertTrue(Prime.isPrime(97));
    }

    @Test
    void shouldReturnFalseForNonPrimeNumbers() {
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(15));
        assertFalse(Prime.isPrime(100));
    }

    @Test
    void shouldWorkWithLargePrime() {
        assertTrue(Prime.isPrime(7919));  // 1000e nombre premier
    }

    @Test
    void shouldReturnFalseForLargeNonPrime() {
        assertFalse(Prime.isPrime(8000));
    }
}

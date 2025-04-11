package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exo1Test2 {
    @Test
    void testNullStringThrowsException() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testLoopNotEnteredForEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void testNonMatchingCharacters() {
        assertFalse(Palindrome.isPalindrome("abc"));
    }

    @Test
    void testMatchingCharacters() {
        assertTrue(Palindrome.isPalindrome("racecar"));
    }
}
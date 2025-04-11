package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exo1Test {
    @Test
    void testNullStringThrowsException() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testEmptyStringIsPalindrome() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void testSingleCharacterIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    void testPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }
}
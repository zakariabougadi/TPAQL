package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exo2Test2 {
    @Test
    void testNullStringThrowsException() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
    }

    @Test
    void testDifferentLengthsReturnFalse() {
        assertFalse(Anagram.isAnagram("cat", "cats"));
    }

    @Test
    void testNonZeroCountReturnsFalse() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }

    @Test
    void testZeroCountReturnsTrue() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
    }
}
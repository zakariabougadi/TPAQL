package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exo2Test3 {
    @Test
    void testS1Null() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
    }

    @Test
    void testS2Null() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
    }

    @Test
    void testDifferentLengths() {
        assertFalse(Anagram.isAnagram("a", "ab"));
    }

    @Test
    void testNonZeroCount() {
        assertFalse(Anagram.isAnagram("abc", "def"));
    }

    @Test
    void testZeroCount() {
        assertTrue(Anagram.isAnagram("tea", "eat"));
    }
}
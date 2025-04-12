package org.example;
//Couverture des lignes
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Exo2Test1 {
    @Test
    void testNullStringThrowsException() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
    }

    @Test
    void testEmptyStringsAreAnagrams() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    void testSimpleAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void testNonAnagramSameLength() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }

    @Test
    void testDifferentLengthStrings() {
        assertFalse(Anagram.isAnagram("cat", "cats"));
    }

    @Test
    void testAnagramWithSpaces() {
        assertTrue(Anagram.isAnagram("silent", "listen "));
    }
}
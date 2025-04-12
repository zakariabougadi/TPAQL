package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTestLineCov {
    @Test
    void testNullArrayThrowsException() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }

    @Test
    void testEmptyArrayReturnsMinusOne() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }

    @Test
    void testElementFoundInMiddle() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    void testElementNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 3}, 4));
    }

    @Test
    void testElementAtStart() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 2, 3}, 1));
    }

    @Test
    void testElementAtEnd() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3}, 3));
    }
}
package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTestBranchCov {
    @Test
    void testNullArrayThrowsException() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }

    @Test
    void testEmptyArraySkipsLoop() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }

    @Test
    void testElementFound() {
        assertEquals(1, BinarySearch.binarySearch(new int[]{1, 2, 3}, 2));
    }

    @Test
    void testElementGreaterThanMid() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3}, 3));
    }

    @Test
    void testElementLessThanMid() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 2, 3}, 1));
    }

    @Test
    void testElementNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 3}, 4));
    }
}
package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTestConditionCov {
    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }

    @Test
    void testLoopNotEntered() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }

    @Test
    void testElementEqualsMid() {
        assertEquals(1, BinarySearch.binarySearch(new int[]{1, 2, 3}, 2));
    }

    @Test
    void testElementLessThanMid() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 2, 3}, 1));
    }

    @Test
    void testElementGreaterThanMid() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 2, 3}, 3));
    }
}
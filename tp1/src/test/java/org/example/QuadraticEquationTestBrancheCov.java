package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTestBrancheCov {
    private static final double DELTA = 0.0001;

    @Test
    void testAZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    @Test
    void testNegativeDelta() {
        assertNull(QuadraticEquation.solve(1, 0, 1));
    }

    @Test
    void testZeroDelta() {
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1}, result, DELTA);
    }

    @Test
    void testPositiveDelta() {
        double[] result = QuadraticEquation.solve(1, -5, 6);
        assertArrayEquals(new double[]{3, 2}, result, DELTA);
    }
}
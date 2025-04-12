package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTestConditionCov {
    private static final double DELTA = 0.0001;

    @Test
    void testAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }

    @Test
    void testDeltaNegative() {
        assertNull(QuadraticEquation.solve(1, 0, 1));
    }

    @Test
    void testDeltaZero() {
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1}, result, DELTA);
    }

    @Test
    void testDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, -1, -2);
        assertArrayEquals(new double[]{2, -1}, result, DELTA);
    }
}
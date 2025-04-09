package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private Matrix matrix;

    @BeforeEach
    void setUp() {
        matrix = new Matrix(2);
        // Initialiser une matrice 2x2: [[1, 2], [3, 4]]
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);
    }

    // Tests pour set et get
    @Test
    void setAndGetShouldWorkCorrectly() {
        matrix.set(0, 0, 5);
        assertEquals(5, matrix.get(0, 0));
    }

    // Tests pour add
    @Test
    void addValidMatrixShouldSumElements() {
        Matrix other = new Matrix(2);
        other.set(0, 0, 1);
        other.set(0, 1, 1);
        other.set(1, 0, 1);
        other.set(1, 1, 1);
        matrix.add(other);
        assertEquals(2, matrix.get(0, 0));
        assertEquals(3, matrix.get(0, 1));
        assertEquals(4, matrix.get(1, 0));
        assertEquals(5, matrix.get(1, 1));
    }

    @Test
    void addNullMatrixShouldThrowException() {
        assertThrows(NullPointerException.class, () -> matrix.add(null));
    }

    @Test
    void addMatrixDifferentSizeShouldThrowException() {
        Matrix other = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> matrix.add(other));
    }

    // Tests pour multiply
    @Test
    void multiplyValidMatrixShouldComputeCorrectly() {
        Matrix other = new Matrix(2);
        other.set(0, 0, 1);
        other.set(0, 1, 0);
        other.set(1, 0, 0);
        other.set(1, 1, 1);
        matrix.multiply(other);
        // Résultat attendu: [[1, 2], [3, 4]]
        assertEquals(1, matrix.get(0, 0));
        assertEquals(2, matrix.get(0, 1));
        assertEquals(3, matrix.get(1, 0));
        assertEquals(4, matrix.get(1, 1));
    }

    @Test
    void multiplyNullMatrixShouldThrowException() {
        assertThrows(NullPointerException.class, () -> matrix.multiply(null));
    }

    @Test
    void multiplyMatrixDifferentSizeShouldThrowException() {
        Matrix other = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> matrix.multiply(other));
    }

    // Tests pour transpose
    @Test
    void transposeShouldSwapRowsAndColumns() {
        matrix.transpose();
        assertEquals(1, matrix.get(0, 0));
        assertEquals(3, matrix.get(0, 1));
        assertEquals(2, matrix.get(1, 0));
        assertEquals(4, matrix.get(1, 1));
    }

    // Tests pour toString
    @Test
    void toStringShouldReturnCorrectRepresentation() {
        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, matrix.toString());
    }
}
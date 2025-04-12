package org.example;

public class QuadraticEquation {
    public static double[] solve(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("a must not be zero");
        }
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) ||
                Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            throw new IllegalArgumentException("Coefficients must be finite and non-NaN");
        }
        double delta = (b * b) - (4 * a * c);
        if (delta < 0) {
            return null;
        }
        if (delta == 0) {
            return new double[] {-b / (2 * a)};
        }
        return new double[] {
                (-b + Math.sqrt(delta)) / (2 * a),
                (-b - Math.sqrt(delta)) / (2 * a)
        };
    }
}
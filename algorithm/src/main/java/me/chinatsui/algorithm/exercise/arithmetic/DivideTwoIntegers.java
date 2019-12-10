package me.chinatsui.algorithm.exercise.arithmetic;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println( 9 % -9);
    }

    public int divide(int dividend, int divisor) {
        // fast special cases
        if (dividend == 0) {
            return 0;
        }

        if (dividend == divisor) {
            return 1;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        // avoid overflow when using -divisor
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        // use positive number arithmetic
        boolean positive = (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0);
        int quotient = 0;

        if (divisor < 0) {
            divisor = -divisor;
        }

        // trick to avoid overflow when using -dividend
        if (dividend == Integer.MIN_VALUE) {
            quotient = 1;
            dividend += divisor;
        }

        if (dividend < 0) {
            dividend = -dividend;
        }

        int boost = 0;
        while (divisor << boost + 1 > 0 && divisor << boost + 1 <= dividend) {
            boost++;
        }

        // find quotient as a sum of powers of 2
        while (dividend >= divisor) {
            if (dividend >= divisor << boost) {
                dividend -= divisor << boost;
                quotient += 1 << boost;
            }
            boost--;
        }

        return positive ? quotient : -quotient;
    }
}

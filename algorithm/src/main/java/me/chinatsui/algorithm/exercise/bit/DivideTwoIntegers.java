package me.chinatsui.algorithm.exercise.bit;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.divide(-12, 2));
    }

    public enum Solution {
        INSTANCE;

        public int divide(int dividend, int divisor) {
            boolean positive = (dividend < 0) == (divisor < 0);
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            if (dividend < divisor) {
                return 0;
            }

            int res = 0;
            while (dividend >= divisor) {
                int tmp = divisor;
                int i = 1;
                while (dividend >= tmp) {
                    dividend -= tmp;
                    res += i;
                    i <<= 1;
                    tmp <<= 1;
                }
            }

            if (!positive) {
                res = -res;
            }

            return Math.min(Math.max(Integer.MIN_VALUE, res), Integer.MAX_VALUE);
        }
    }
}

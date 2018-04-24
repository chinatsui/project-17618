package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum Pow {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.myPow(2.00000, 10));
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double result = 1;
        for (double f = x; n > 0; n = n >> 1) {
            if (n % 2 == 1) {
                result *= f;
            }
            f = f * f;
        }

        return result;
    }

}

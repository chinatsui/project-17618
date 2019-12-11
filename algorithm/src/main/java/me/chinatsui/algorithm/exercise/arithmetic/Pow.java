package me.chinatsui.algorithm.exercise.arithmetic;

public class Pow {

    public static double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x = x * x;
            n >>= 1;
        }
        return res;
    }
}

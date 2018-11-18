package me.chinatsui.algorithm.exercise.arithmetic;

public class Pow {

    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.pow(2.00000, 10));
    }

    public enum Solution {
        INSTANCE;

        public double pow(double x, int n) {
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
}

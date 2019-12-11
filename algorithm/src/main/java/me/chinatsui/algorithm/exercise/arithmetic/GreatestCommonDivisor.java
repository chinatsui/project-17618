package me.chinatsui.algorithm.exercise.arithmetic;

public class GreatestCommonDivisor {

    public static int getGCD(int x, int y) {
        while (y > 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x;
    }
}

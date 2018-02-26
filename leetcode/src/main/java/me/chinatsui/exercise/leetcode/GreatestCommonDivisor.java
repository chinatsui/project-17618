package me.chinatsui.exercise.leetcode;

/**
 * Created by chinatsui on 14/01/2018.
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisor().gcd(42,31));
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}

package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisor().gcd(42,31));
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}

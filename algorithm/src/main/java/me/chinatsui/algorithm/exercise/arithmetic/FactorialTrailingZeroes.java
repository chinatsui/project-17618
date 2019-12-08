package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 172. Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }

        long i = 5, cnt = 0;
        while (i <= n) {
            cnt += n / i;
            i *= 5;
        }

        return (int)cnt;
    }
}

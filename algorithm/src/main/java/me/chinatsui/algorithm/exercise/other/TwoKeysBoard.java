package me.chinatsui.algorithm.exercise.other;

/**
 * LeetCode 650. 2 Keys Keyboard
 *
 * Initially on a notepad only one character 'A' is present.
 * You can perform two operations on this notepad for each step:
 * - Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * - Paste: You can paste the characters which are copied last time.
 *
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted.
 * Output the minimum number of steps to get n 'A'.
 *
 * Example 1:
 * Input: 3
 * Output: 3
 * Explanation:
 * Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 */
public class TwoKeysBoard {

    /*
     * Now, try to find the rule...
     * n = 6.
     * We need the lowest number (starts from 2) for 6 % x == 0, x should be 2.
     * To get 6'A's, we need to copy 'AA's three times. (3)
     * To get 2'A's, we need to copy the 1'A' two times. (2)
     * So the answer is 3 + 2 = 5.

     * n = 9.
     * We need the lowest number (starts from 2) for 9 % x == 0, x should be 3.
     * To get 9'A's, we need to copy 'AAA' three times. (3)
     * To get 3'A', we need to copy 'A' three times. (3)
     * So the answer is 3 + 3 = 6.

     * n = 81.
     * We need the lowest number (starts from 2) for 81 % x == 0, x should be 3.
     * To get 81'A's, we need to copy 27'A's three times. (3)
     * To get 27'A's, we need to copy 9'A's three times. (3)
     * To get 9'A's, we need to copy 3'A's three times. (3)
     * To get 3'A's, we need to copy 1'A's three times. (3)
     * Final answer is 3 + 3 + 3 + 3 = 12.

     * n = 18.
     * We need the lowest number (starts from 2) for 18 % x == 0, x should be 2.
     * To get 18'A's, we need to copy 9'A's two times. (2)
     * To get 9'A's, we need to copy 3'A's three times. (3)
     * To get 3'A's, we need to copy 1'A's three times. (3)
     * Answer: 2 + 3 + 3 = 8.
     */
    public int minSteps(int n) {
        int steps = 0;
        for (int divisor = 2; divisor <= n; divisor++) {
            while (n % divisor == 0) {
                steps += divisor;
                n /= divisor;
            }
        }
        return steps;
    }
}

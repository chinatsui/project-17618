package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode-91
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    /**
     * dp[i] = dp[i - 1], s.substring(i, i + 1) > 0
     *      += dp[i - 2], 10 <= s.substring(i-1, i + 1) <= 26
     */
    public int decodeWays(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int num1 = Integer.valueOf(s.substring(i, i + 1));
            if (num1 > 0) {
                dp[i] = dp[i - 1];
            }
            int num2 = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num2 >= 10 && num2 <= 26) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }

        return dp[n - 1];
    }
}
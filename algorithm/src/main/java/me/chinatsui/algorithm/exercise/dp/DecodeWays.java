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

    public int decodeWays(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int n = s.length();

        // dp[i] means the ways of decoding first i digits that is 0...i-1
        int[] dp = new int[n + 1];
        dp[0] = 1; // first 0 digits cannot be decoded, this should be regarded as one way.

        char[] ch = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            // last digit
            int num1 = ch[i - 1] - '0';
            if (num1 >= 1 && num1 <= 9) {
                dp[i] += dp[i - 1];
            }

            // last two digits
            if (i > 1) {
                int num2 = (ch[i - 2] - '0') * 10 + ch[i - 1] - '0';
                if (num2 >= 10 && num2 <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n];
    }
}

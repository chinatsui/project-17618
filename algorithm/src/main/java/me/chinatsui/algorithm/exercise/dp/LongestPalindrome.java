package me.chinatsui.algorithm.exercise.dp;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {

    public String resolve(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() < 1) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        String res = s.substring(0, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + 1 < i - 1) {
                    dp[j][i] = s.charAt(j) == s.charAt(i) && dp[j + 1][i - 1];
                } else {
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                }

                if (dp[j][i]) {
                    res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res;
                }
            }
        }

        return res;
    }
}

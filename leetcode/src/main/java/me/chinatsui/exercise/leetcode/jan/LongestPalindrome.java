package me.chinatsui.exercise.leetcode.jan;

/**
 * Created by chinatsui on 10/01/2018.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(new LongestPalindrome().longestPalindrome(input));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String max = "";
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (max.length() == 0 || j - i + 1 > max.length())) {
                    max = s.substring(i, j + 1);
                }
            }
        }

        return max;
    }

}

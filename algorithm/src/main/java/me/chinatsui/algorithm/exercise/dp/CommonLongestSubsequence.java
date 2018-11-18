package me.chinatsui.algorithm.exercise.dp;

public class CommonLongestSubsequence {

    public static void main(String[] args) {
        String a = "bedaacbade";
        String b = "dccaeedbeb";

        System.out.println(new CommonLongestSubsequence().getCLS(a, b));
    }

    public String getCLS(String A, String B) {
        if (A == null || A.length() == 0) {
            return "";
        }

        if (B == null || B.length() == 0) {
            return "";
        }

        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m][n];
        String[][] dpStr = new String[m][n];

        for (int i = 0; i < m; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                dp[i][0] = 1;
                dpStr[i][0] = String.valueOf(B.charAt(0));
            } else {
                dp[i][0] = 0;
                dpStr[i][0] = "";
            }
        }

        for (int j = 0; j < n; j++) {
            if (A.charAt(0) == B.charAt(j)) {
                dp[0][j] = 1;
                dpStr[0][j] = String.valueOf(A.charAt(0));
            } else {
                dp[0][j] = 0;
                dpStr[0][j] = "";
            }
        }

        /*
         *             dp(i-1, j-1) + 1, a[i] = b[j]
         *  dp(i,j) =  dp(i, j - 1), a[i] != b[j] && dp(i, j - 1) > dp(i - 1, j)
         *             dp(i - 1, j), a[i] != b[j] && dp(i, j - 1) < dp(i - 1, j)
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dpStr[i][j] = dpStr[i-1][j-1] + String.valueOf(A.charAt(i));
                } else {
                    if (dp[i][j-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i][j-1];
                        dpStr[i][j] = dpStr[i][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j];
                        dpStr[i][j] = dpStr[i-1][j];
                    }
                }
            }
        }

        return dpStr[m - 1][n - 1];
    }

}
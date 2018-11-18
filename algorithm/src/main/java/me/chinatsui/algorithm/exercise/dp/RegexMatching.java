package me.chinatsui.algorithm.exercise.dp;

public enum RegexMatching {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.isMatch("aa", "aa"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <=n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i<=m; i++) {
            for (int j = 1; j<=n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = true && dp[i][j-1];
                } else {
                    dp[i][j] = dp[i - 1][j] && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.');
                }
            }
        }

        return dp[m][n];
    }

}

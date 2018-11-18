package me.chinatsui.algorithm.exercise.dp;

public enum Knapsack01 {

    INSTANCE;

    int[] p = {6, 3, 5, 4, 6};  // 价值
    int[] w = {2, 2, 6, 5, 4};  // 重量

    public static void main(String[] args) {
        System.out.println(INSTANCE.getMaxValue(10));
    }

    public int getMaxValue(int v) {
        int m = p.length;
        int[][] dp = new int[m + 1][v + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= v; j++) {
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][v];
    }
}

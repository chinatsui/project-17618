package me.chinatsui.exercise.leetcode;


public class PaintHouse {

    /*
     [
      [14,2,11],
      [11,14,5],
      [14,3,10]
     ]

       n: house id  0 - (n-1)
       k: color 0, 1, 2

       dp(n, 0) = value(n,0) + Math.min(dp(n-1, 1), dp(n-1, 2));
       dp(n, 1) = value(n,1) + Math.min(dp(n-1, 0), dp(n-1, 2));
       dp(n, 2) = value(n,2) + Math.min(dp(n-1, 0), dp(n-1, 1));
       dp(n) = Math.min(dp(n, 0), dp(n, 1), dp(n, 2));
     */

    public static void main(String[] args) {
        int[][] input = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
        System.out.println(new PaintHouse().minCost(input));
    }

    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;

        int[][] cdp = new int[n][3];

        // initialize first house cost
        cdp[0][0] = costs[0][0];
        cdp[0][1] = costs[0][1];
        cdp[0][2] = costs[0][2];

        int[] dp = new int[n];
        dp[0] = Math.min(cdp[0][0], Math.min(cdp[0][1], cdp[0][2]));

        // iterate 1 ~ n
        for (int i = 1; i < n; i++) {
            cdp[i][0] = costs[i][0] + Math.min(cdp[i - 1][1], cdp[i - 1][2]);
            cdp[i][1] = costs[i][1] + Math.min(cdp[i - 1][0], cdp[i - 1][2]);
            cdp[i][2] = costs[i][2] + Math.min(cdp[i - 1][0], cdp[i - 1][1]);
            dp[i] = Math.min(cdp[i][0], Math.min(cdp[i][1], cdp[i][2]));
        }

        return dp[n - 1];
    }

}

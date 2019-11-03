package me.chinatsui.algorithm.exercise.dp;

import java.util.ArrayList;

/**
 * weights[], values[], maxWeight
 */
public class KnapsackII {

    public static void main(String[] args) {
        int[] weights = {2, 2, 6, 5, 4};
        int[] values = {6, 3, 5, 4, 6};
        KnapsackII knapsack = new KnapsackII();
        System.out.println(knapsack.resolve_v2(weights, values, 10));
    }

    public int resolve(int[] weights, int[] values, int maxWeight) {
        if (!isValid(weights, values, maxWeight)) {
            return 0;
        }

        int n = weights.length;
        // dp[i][j]: the value (not max value) after visited the "i"th element with current weight of j.
        int[][] dp = new int[n][maxWeight + 1];

        // initialization
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxWeight; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;
        dp[0][weights[0]] = values[0];
        for (int i = 1; i < weights.length; i++) {
            // in the case of excluding the ith item.
            for (int w = 0; w <= maxWeight; w++) {
                if (dp[i - 1][w] >= 0) {
                    dp[i][w] = dp[i - 1][w];
                }
            }

            // in the case of including the ith item.
            for (int w = 0; w <= maxWeight - weights[i]; w++) {
                if (dp[i - 1][w] >= 0) {
                    dp[i][w + weights[i]] = Math.max(dp[i][w + weights[i]], dp[i - 1][w] + values[i]);
                }
            }
        }

        int maxValue = -1;
        int cw = -1;
        for (int w = maxWeight; w >= 0; w--) {
            if (dp[n - 1][w] > maxValue) {
                maxValue = dp[n - 1][w];
                cw = w;
            }
        }

        /*
         * The way to list involved items.
         */
        int cv = maxValue;
        ArrayList<Integer> items = new ArrayList<>();
        for (int i = n - 1; i >= 1; i--) {
            if (cw >= weights[i] && dp[i - 1][cw - weights[i]] == cv - values[i]) {
                items.add(values[i]);
                cv -= values[i];
                cw -= weights[i];
            }

            if (i == 1 && cw > 0) {
                items.add(values[0]);
            }
        }

        return maxValue;
    }

    public int resolve_v2(int[] weights, int[] values, int maxWeight) {
        if (!isValid(weights, values, maxWeight)) {
            return 0;
        }

        int n = weights.length;
        // dp[i][j]: the max value of first i (NOT "i"th) elements in the capacity of j
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][maxWeight];
    }

    private boolean isValid(int[] weights, int[] values, int maxWeight) {
        if (weights == null || values == null || maxWeight < 0) {
            return false;
        }

        if (weights.length != values.length) {
            return false;
        }

        return true;
    }
}

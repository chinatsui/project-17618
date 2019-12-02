package me.chinatsui.algorithm.exercise.dp;

public class RangeMinimumQuery {

    private int[][] cache;

    public RangeMinimumQuery(int[] nums) {
        int n = nums.length;
        cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            cache[i][i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cache[i][j] = nums[cache[i][j - 1]] < nums[j] ? cache[i][j - 1] : j;
            }
        }
    }

    public int query(int i, int j) {
        return cache[i][j];
    }
}

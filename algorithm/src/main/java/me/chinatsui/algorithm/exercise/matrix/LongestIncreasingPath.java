package me.chinatsui.algorithm.exercise.matrix;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPath {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},};

    public int resolve(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;
        int[][] cache = new int[n][m];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(grid, i, j, cache));
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int dist = 0;
        for (int[] adj : getValidAdjacent(grid, i, j)) {
            dist = Math.max(dist, dfs(grid, adj[0], adj[1], cache));
        }

        int res = 1 + dist;
        cache[i][j] = res;

        return res;
    }

    private List<int[]> getValidAdjacent(int[][] grid, int i, int j) {
        List<int[]> adj = new ArrayList<>();

        for (int[] d : directions) {
            int x = i + d[0], y = j + d[0];
            if (isValid(x, y, grid.length, grid[0].length) && grid[i][j] < grid[x][y]) {
                adj.add(new int[]{x, y});
            }
        }

        return adj;
    }


    private boolean isValid(int x, int y, int n, int m) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

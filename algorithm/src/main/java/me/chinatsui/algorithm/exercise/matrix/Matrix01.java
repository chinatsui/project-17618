package me.chinatsui.algorithm.exercise.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 542. 01 Matrix
 * <p>
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * <p>
 * Example 1:
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Example 2:
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class Matrix01 {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return matrix;
        }

        int n = matrix.length, m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            for (int[] d : directions) {
                int x = i + d[0], y = j + d[1];
                if (isValid(matrix, x, y) && matrix[x][y] != 0 && !visited[x][y]) {
                    matrix[x][y] = matrix[i][j] + 1;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        return matrix;
    }

    private boolean isValid(int[][] matrix, int x, int y) {
        return 0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length;
    }
}

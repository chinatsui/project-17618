package me.chinatsui.algorithm.exercise.matrix;

/**
 * LeetCode-73
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * Example 2:
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * Follow up:
 * 1. A straight forward solution using O(mn) space is probably a bad idea.
 * 2. A simple improvement uses O(m + n) space, but still not the best solution.
 * 3. Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }

        int n = matrix.length, m = matrix[0].length;
        boolean col0Set = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                col0Set = true;
            }

            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (col0Set) {
                matrix[i][0] = 0;
            }
        }
    }
}

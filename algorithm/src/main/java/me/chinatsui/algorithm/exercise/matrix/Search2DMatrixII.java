package me.chinatsui.algorithm.exercise.matrix;

/**
 * LeetCode 240. Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * - Integers in each row are sorted in ascending from left to right.
 * - Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >=0) {
            if (target <= matrix[i][j]) {
                int lo = 0, hi = j;
                while (lo <= hi) {
                    int mi = lo + (hi - lo) / 2;
                    if (matrix[i][mi] == target) {
                        return true;
                    } else if (target < matrix[i][mi]) {
                        hi = mi - 1;
                    } else {
                        lo = mi + 1;
                    }
                }
            } else {
                int lo = i, hi = n - 1;
                while (lo <= hi) {
                    int mi = lo + (hi - lo) / 2;
                    if (target == matrix[mi][j]) {
                        return true;
                    } else if (target < matrix[mi][j]) {
                        hi = mi - 1;
                    } else {
                        lo = mi + 1;
                    }
                }
            }
            i++;
            j--;
        }
        return false;
    }
}

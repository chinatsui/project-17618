package me.chinatsui.algorithm.exercise.matrix;

/**
 * LeetCode 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Search2DMatrix {

    public boolean search(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = n - 1;

        // specify which row
        int row = -1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (matrix[mi][0] >= target) {
                if (mi == 0 || matrix[mi - 1][0] < target) {
                    if (matrix[mi][0] == target) {
                        return true;
                    } else if (mi == 0) {
                        return false;
                    } else {
                        row = mi - 1;
                        break;
                    }
                } else {
                    hi = mi - 1;
                }
            } else {
                lo = mi + 1;
            }
        }

        // didn't find the first matrix[i][0] greater than or equals to target, so we have to search it in the last row.
        if (row == -1) {
            row = n - 1;
        }

        lo = 0;
        hi = m - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (target == matrix[row][mi]) {
                return true;
            } else if (target < matrix[row][mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }

        return false;
    }
}

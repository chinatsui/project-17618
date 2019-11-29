package me.chinatsui.algorithm.exercise.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 54. Spiral Matrix
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public List<Integer> order(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new ArrayList<>();
        }

        int rowStart = 0, rowEnd = matrix.length - 1, columnStart = 0, columnEnd = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int k = columnStart; k <= columnEnd; k++) {
                res.add(matrix[rowStart][k]);
            }
            rowStart++;

            for (int k = rowStart; k <= rowEnd; k++) {
                res.add(matrix[k][columnEnd]);
            }
            columnEnd--;


            if (rowStart <= rowEnd) {
                for (int k = columnEnd; k >= columnStart; k--) {
                    res.add(matrix[rowEnd][k]);
                }
                rowEnd--;
            }


            if (columnStart <= columnEnd) {
                for (int k = rowEnd; k >= rowStart; k--) {
                    res.add(matrix[k][columnStart]);
                }
                columnStart++;
            }
        }

        return res;
    }
}

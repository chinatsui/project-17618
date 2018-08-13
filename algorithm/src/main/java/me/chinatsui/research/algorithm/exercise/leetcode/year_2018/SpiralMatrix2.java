package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SpiralMatrix2 {

    INSTANCE;

    public static void main(String[] args) {
//        int[][] input = {{3}, {2}};
//        List<Integer> list = INSTANCE.spiralOrder(input);
//        System.out.println(list);

        System.out.println(Arrays.asList(1));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new ArrayList();
        }

        int m = matrix.length, n = matrix[0].length;
        int direction = 0; // 0: left to right, 1: top to bottom, 2: right to left, 3: bottom to top;
        int left = 0, top = 0, right = n - 1, bottom = m - 1;
        int i = 0, j = 0;

        List<Integer> result = new ArrayList();
        for (int k = 0; k < m*n; k++) {
            result.add(matrix[i][j]);

            if (direction == 0) {
                if (j == right) {
                    direction++;
                    top++;
                    i++;
                } else {
                    j++;
                }
            } else if (direction == 1) {
                if (i == bottom) {
                    direction++;
                    right--;
                    j--;
                } else {
                    i++;
                }
            } else if (direction == 2) {
                if (j == left) {
                    direction++;
                    bottom--;
                    i--;
                } else {
                    j--;
                }
            } else {
                if (i == top) {
                    direction = 0;
                    left++;
                    j++;
                } else {
                    i--;
                }
            }
        }
        return result;
    }

}

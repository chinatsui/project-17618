package me.chinatsui.algorithm.exercise.matrix;

import java.util.ArrayList;
import java.util.List;

public enum SpiralMatrix {

    INSTANCE;

    public static void main(String[] args) {
        int[][] matrix = {{2,3}};
        List<Integer> trace = INSTANCE.spiralOrder_2(matrix);
        System.out.println(trace);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> results = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int rowStart = 0;
        int rowEnd = m - 1;
        int columnStart = 0;
        int columnEnd = n - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int j = columnStart; j <= columnEnd; j++) {
                results.add(matrix[rowStart][j]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                results.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            if (rowStart <= rowEnd) {
                for (int j = columnEnd; j >= columnStart; j--) {
                    results.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            if (columnStart <= columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    results.add(matrix[i][columnStart]);
                }
                columnStart++;
            }
        }

        return results;
    }

    public List<Integer> spiralOrder_2(int[][] matrix) {
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

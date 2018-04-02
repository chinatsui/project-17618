package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.List;

public enum SpiralMatrix {

    INSTANCE;

    public static void main(String[] args) {
        int[][] matrix = {{2,3}};
        List<Integer> history = INSTANCE.spiralOrder(matrix);
        System.out.println(history);
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

}

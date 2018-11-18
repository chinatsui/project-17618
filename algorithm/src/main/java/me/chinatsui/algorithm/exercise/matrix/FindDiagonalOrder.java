package me.chinatsui.algorithm.exercise.matrix;

import java.util.Arrays;

public enum FindDiagonalOrder {

    INSTANCE;

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] result = INSTANCE.findDiagonalOrder(input);
        System.out.println(Arrays.toString(result));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return null;
        }

        boolean up = true;
        int i = 0, j = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];

        for (int k = 0; k < m * n; k++) {
            result[k] = matrix[i][j];
            if (up) {
                i--;
                j++;
                if (i == -1 && j == n) {
                    i += 2;
                    j--;
                    up = false;
                } else if (i == -1) {
                    i++;
                    up = false;
                } else if (j == n) {
                    i += 2;
                    j--;
                    up = false;
                }
            } else {
                i++;
                j--;
                if (j == -1 && i == m) {
                    i--;
                    j += 2;
                    up = true;
                } else if (j == -1) {
                    j++;
                    up = true;
                } else if (i == m) {
                    i--;
                    j += 2;
                    up = true;
                }
            }
        }

        return result;
    }

}

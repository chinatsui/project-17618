package me.chinatsui.algorithm.exercise.matrix;

/**
 * LeetCode 498. Diagonal Traverse
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix
 * in diagonal order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }

        int n = matrix.length, m = matrix[0].length, maxLevel = n + m - 1, level = 0;
        boolean up = true;
        int[] res = new int[n * m];
        int cur = 0;
        while (level <= maxLevel) {
            if (up) {
                int x = Math.min(n - 1, level);
                for (int i = x; i >= 0; i--) {
                    int j = level - i;
                    if (j == m) {
                        break;
                    }
                    res[cur++] = matrix[i][j];
                }
            } else {
                int y = Math.min(m - 1, level);
                for (int j = y; j >= 0; j--) {
                    int i = level - j;
                    if (i == n) {
                        break;
                    }
                    res[cur++] = matrix[i][j];
                }
            }
            up = !up;
            level++;
        }

        return res;
    }
}

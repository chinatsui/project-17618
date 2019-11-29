package me.chinatsui.algorithm.exercise.matrix;

import org.junit.Assert;
import org.junit.Test;

public class DiagonalTraverseTest {

    private DiagonalTraverse diagonalTraverse = new DiagonalTraverse();

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Assert.assertArrayEquals(
                new int[]{1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12},
                diagonalTraverse.findDiagonalOrder(matrix));
    }
}

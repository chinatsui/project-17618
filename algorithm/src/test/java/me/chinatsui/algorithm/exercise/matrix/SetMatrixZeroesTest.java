package me.chinatsui.algorithm.exercise.matrix;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeroesTest {

    private SetMatrixZeroes smz = new SetMatrixZeroes();

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5}
        };
        smz.setZeroes(matrix);
        int[][] expected = new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{0, 4, 5, 0},
                new int[]{0, 3, 1, 0}
        };
        Assert.assertArrayEquals(expected, matrix);
    }
}

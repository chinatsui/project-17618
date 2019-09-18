package me.chinatsui.algorithm.exercise.matrix;

import me.chinatsui.algorithm.exercise.matrix.SpiralMatrix;
import org.junit.Assert;
import org.junit.Test;

public class SpiralMatrixTest {

    private SpiralMatrix sp = new SpiralMatrix();

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}};
        int[] expected = new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        int[] actual = sp.order(matrix).stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(expected, actual);
    }
}

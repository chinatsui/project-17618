package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinimumPathSumTest {

    private MinimumPathSum mps = new MinimumPathSum();

    @Test
    public void test() {
        int[][] grid = new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1},
        };
        Assert.assertEquals(7, mps.resolve(grid));
    }
}

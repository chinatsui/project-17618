package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsIITest {

    private UniquePathsII up2 = new UniquePathsII();

    @Test
    public void test() {
        int[][] grid = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };

        Assert.assertEquals(2, up2.resolve(grid));
    }
}

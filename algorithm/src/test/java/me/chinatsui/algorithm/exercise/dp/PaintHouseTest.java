package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class PaintHouseTest {

    private PaintHouse ph = new PaintHouse();

    @Test
    public void test() {
        int[][] costs = new int[][]{
                new int[]{14, 2, 11},
                new int[]{11, 14, 5},
                new int[]{14, 3, 10},
        };
        Assert.assertEquals(10, ph.minCost(costs));
    }
}

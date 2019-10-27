package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class BombEnemyTest {

    private BombEnemy be = new BombEnemy();

    @Test
    public void test() {
        char[][] grid = new char[][]{
                new char[]{'0', 'E', '0', '0'},
                new char[]{'E', '0', 'W', 'E'},
                new char[]{'0', 'E', '0', '0'}
        };

        Assert.assertEquals(3, be.maxKilled(grid));
    }
}

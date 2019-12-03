package me.chinatsui.algorithm.exercise.graph;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BreakWallTest {

    private BreakWall bw;

    @Before
    public void setup() {
        int[][] matrix = new int[][]{
                new int[]{0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                new int[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
                new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                new int[]{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                new int[]{1, 1, 0, 0, 0, 0, 1, 0, 0, 1},
        };
        bw = new BreakWall(matrix);
    }

    @Test
    public void test() {
        List<BreakWall.Position> path = bw.shortestPath(new BreakWall.Position(0, 0), new BreakWall.Position(4, 3));
        Assert.assertEquals(8, path.size());
        path = bw.shortestPath(new BreakWall.Position(0, 0), new BreakWall.Position(1, 5));
        Assert.assertEquals(0, path.size());
    }
}

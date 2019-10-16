package me.chinatsui.algorithm.exercise.backtrack;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EightQueensTest {

    private EightQueens eq = new EightQueens();

    @Test
    public void test() {
        List<int[]> res = eq.resolve();
        Assert.assertEquals(92, res.size());
        Assert.assertArrayEquals(new int[]{0, 4, 7, 5, 2, 6, 1, 3}, res.get(0));
        Assert.assertArrayEquals(new int[]{0, 5, 7, 2, 6, 3, 1, 4}, res.get(1));
        Assert.assertArrayEquals(new int[]{0, 6, 3, 5, 7, 1, 4, 2}, res.get(2));
        Assert.assertArrayEquals(new int[]{0, 6, 4, 7, 1, 3, 5, 2}, res.get(3));
    }
}

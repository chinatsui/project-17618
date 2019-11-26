package me.chinatsui.algorithm.exercise.greedy;

import me.chinatsui.algorithm.exercise.greedy.MergeIntervals;
import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalsTest {

    private MergeIntervals mi = new MergeIntervals();

    @Test
    public void test01() {
        int[][] intervals = new int[][]{
                new int[]{1, 4},
                new int[]{2, 3}
        };

        int[][] expected = new int[][]{
                new int[]{1, 4}
        };

        Assert.assertArrayEquals(expected, mi.merge(intervals));
    }

    @Test
    public void test02() {
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        };

        int[][] expected = new int[][]{
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        };

        Assert.assertArrayEquals(expected, mi.merge(intervals));
    }

    @Test
    public void test03() {
        int[][] intervals = new int[][]{
                new int[]{1, 4},
                new int[]{4, 5}
        };

        int[][] expected = new int[][]{
                new int[]{1, 5}
        };

        Assert.assertArrayEquals(expected, mi.merge(intervals));
    }
}

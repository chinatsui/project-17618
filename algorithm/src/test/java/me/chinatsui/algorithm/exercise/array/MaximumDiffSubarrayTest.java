package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MaximumDiffSubarrayTest {

    private MaximumDiffSubarray mds = new MaximumDiffSubarray();

    @Test
    public void test() {
        Assert.assertEquals(11, mds.maxDiff(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

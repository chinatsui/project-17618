package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSumSubarrayTest {

    private MinimumSumSubarray ms = new MinimumSumSubarray();

    @Test
    public void test() {
        Assert.assertEquals(-10, ms.minSum(new int[]{-2, 1, -3, 1, -1, -2, 1, -5, 4}));
    }
}

package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSubarrayTest {

    private MinimumSubarray ms = new MinimumSubarray();

    @Test
    public void test() {
        Assert.assertEquals(-10, ms.minSum(new int[]{-2, 1, -3, 1, -1, -2, 1, -5, 4}));
    }
}

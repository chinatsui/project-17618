package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarrayTest {

    private MaximumSubarray ms = new MaximumSubarray();

    @Test
    public void test() {
        Assert.assertEquals(6, ms.maxSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

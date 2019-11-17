package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSizeSubarraySumTest {

    private MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();

    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        Assert.assertEquals(2, msss.minSubArrayLen(7, nums));
    }
}

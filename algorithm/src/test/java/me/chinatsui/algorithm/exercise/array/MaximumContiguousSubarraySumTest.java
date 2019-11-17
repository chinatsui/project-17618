package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MaximumContiguousSubarraySumTest {

    private MaximumContiguousSubarraySum mcsas = new MaximumContiguousSubarraySum();

    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 4, 1, 1, 2, 3, 1, -1, -4, 7, 9, 15, 16, 1, -1};
        Assert.assertEquals(9, mcsas.getMaxLength(nums, 9));
    }
}

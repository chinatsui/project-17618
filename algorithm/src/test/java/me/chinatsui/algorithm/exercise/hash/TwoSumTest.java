package me.chinatsui.algorithm.exercise.hash;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    private TwoSum ts = new TwoSum();

    @Test
    public void test_01() {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        Assert.assertArrayEquals(new int[]{1, 2}, ts.twoSum(nums, target));
    }
}

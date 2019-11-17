package me.chinatsui.algorithm.exercise.queue;

import org.junit.Assert;
import org.junit.Test;

public class MaxSlidingWindowTest {

    private MaxSlidingWindow msw = new MaxSlidingWindow();

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, msw.maxSlidingWindow(nums, 3));
    }
}

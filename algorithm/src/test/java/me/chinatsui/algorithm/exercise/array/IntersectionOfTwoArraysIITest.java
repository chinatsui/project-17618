package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoArraysIITest {

    private IntersectionOfTwoArraysII iotaii = new IntersectionOfTwoArraysII();

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        Assert.assertArrayEquals(new int[]{2, 2}, iotaii.intersect(nums1, nums2));
    }
}

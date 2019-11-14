package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoArraysTest {

    private IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        Assert.assertArrayEquals(new int[]{2}, iota.intersect(nums1, nums2));
    }
}

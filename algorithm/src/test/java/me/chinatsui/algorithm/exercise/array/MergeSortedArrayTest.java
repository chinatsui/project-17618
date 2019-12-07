package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrayTest {

    private MergeSortedArray msa = new MergeSortedArray();

    @Test
    public void test() {
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        msa.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }
}

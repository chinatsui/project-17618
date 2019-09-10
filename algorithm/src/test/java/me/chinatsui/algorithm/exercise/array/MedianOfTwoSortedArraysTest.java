package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

    private MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();

    @Test
    public void test() {
        Assert.assertEquals((double) 3, motsa.resolve(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}), 0);
        Assert.assertEquals((double) 11, motsa.resolve(new int[]{2, 3, 5, 8}, new int[]{10, 12, 14, 16, 18, 20}), 0);
        Assert.assertEquals(2.5, motsa.resolve(new int[]{}, new int[]{2, 3}), 0);
    }
}

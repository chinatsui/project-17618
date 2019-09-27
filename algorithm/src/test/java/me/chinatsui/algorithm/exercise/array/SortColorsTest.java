package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.util.Nums;

public class SortColorsTest {

    private SortColors sc = new SortColors();

    @Test
    public void test() {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sc.sort(nums);
        Assert.assertTrue(Nums.isAscending(nums));

        nums = new int[]{1, 1, 0, 0, 2, 2};
        sc.sort(nums);
        Assert.assertTrue(Nums.isAscending(nums));

        nums = new int[]{2, 2, 0, 0, 1, 2};
        sc.sort(nums);
        Assert.assertTrue(Nums.isAscending(nums));
    }
}

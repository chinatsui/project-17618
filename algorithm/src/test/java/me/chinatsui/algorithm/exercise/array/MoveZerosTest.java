package me.chinatsui.algorithm.exercise.array;

import org.junit.Assert;
import org.junit.Test;

public class MoveZerosTest {

    private MoveZeros mz = new MoveZeros();

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }
}

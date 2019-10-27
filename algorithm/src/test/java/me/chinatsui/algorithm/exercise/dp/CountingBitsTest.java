package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class CountingBitsTest {

    private CountingBits cb = new CountingBits();

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, cb.count(5));
    }
}

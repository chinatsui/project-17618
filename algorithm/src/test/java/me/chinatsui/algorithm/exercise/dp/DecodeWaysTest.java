package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class DecodeWaysTest {

    private DecodeWays dw = new DecodeWays();

    @Test
    public void test() {
        Assert.assertEquals(0, dw.decodeWays("01"));
        Assert.assertEquals(1, dw.decodeWays("10"));
        Assert.assertEquals(3, dw.decodeWays("123"));
        Assert.assertEquals(3, dw.decodeWays("226"));
    }
}

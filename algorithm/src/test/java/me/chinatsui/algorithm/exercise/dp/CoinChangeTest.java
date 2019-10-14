package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {

    private CoinChange cc = new CoinChange();

    @Test
    public void test() {
        Assert.assertEquals(3, cc.resolve(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(-1, cc.resolve(new int[]{2}, 3));
    }
}

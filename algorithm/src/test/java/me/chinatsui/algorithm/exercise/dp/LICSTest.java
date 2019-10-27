package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class LICSTest {

    private LICS lics = new LICS();

    @Test
    public void test() {
        Assert.assertEquals(3, lics.findLength(new int[]{1, 3, 5, 4, 7}));
        Assert.assertEquals(1, lics.findLength(new int[]{2, 2, 2, 2, 2}));
    }
}

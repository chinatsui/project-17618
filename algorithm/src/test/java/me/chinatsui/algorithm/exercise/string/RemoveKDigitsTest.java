package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class RemoveKDigitsTest {
    private RemoveKDigits rkd = new RemoveKDigits();

    @Test
    public void test() {
        Assert.assertEquals("1219", rkd.removeKDigits("1432219", 3));
        Assert.assertEquals("200", rkd.removeKDigits("10200", 1));
        Assert.assertEquals("0", rkd.removeKDigits("10", 2));
    }
}

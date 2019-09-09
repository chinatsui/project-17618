package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class AtoiTest {

    private Atoi atoi = new Atoi();

    @Test
    public void test() {
        Assert.assertEquals(42, atoi.convert("42"));
        Assert.assertEquals(-42, atoi.convert("    -42"));
        Assert.assertEquals(4193, atoi.convert("4193 other words"));
        Assert.assertEquals(0, atoi.convert("words and 987"));
        Assert.assertEquals(-2147483648, atoi.convert("-91283472332"));
    }
}

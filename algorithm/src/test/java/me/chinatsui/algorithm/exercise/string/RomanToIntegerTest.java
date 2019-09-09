package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class RomanToIntegerTest {

    private RomanToInteger rti = new RomanToInteger();

    @Test
    public void test() {
        Assert.assertEquals(1994, rti.resolve("MCMXCIV"));
        Assert.assertEquals(58, rti.resolve("LVIII"));
        Assert.assertEquals(9, rti.resolve("IX"));
        Assert.assertEquals(4, rti.resolve("IV"));
        Assert.assertEquals(3, rti.resolve("III"));
    }
}

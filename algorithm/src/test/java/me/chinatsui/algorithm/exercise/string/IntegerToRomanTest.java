package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToRomanTest {

    private IntegerToRoman itr = new IntegerToRoman();

    @Test
    public void test() {
        Assert.assertEquals("MCMXCIV", itr.resolve(1994));
        Assert.assertEquals("LVIII", itr.resolve(58));
        Assert.assertEquals("XLI", itr.resolve(41));
        Assert.assertEquals("X", itr.resolve(10));
        Assert.assertEquals("IX", itr.resolve(9));
        Assert.assertEquals("IV", itr.resolve(4));
        Assert.assertEquals("III", itr.resolve(3));
    }
}

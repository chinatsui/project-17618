package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class RegexPatternTest {

    @Test
    public void Test() {
        RegexPattern rp = new RegexPattern("a*bcd?xx");
        Assert.assertEquals(4, rp.match("dcdcacvcbcdxx"));
    }
}

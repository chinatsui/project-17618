package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    private Regex regex = new Regex();

    @Test
    public void Test() {
        Assert.assertEquals(4, regex.match("dcdcacvcbcdxx", "a*bcd?xx"));
        Assert.assertEquals(4, regex.match("dcdcabcdxx", "a*bcd?xx"));
        Assert.assertEquals(0, regex.match("cd", "cd?***"));
        Assert.assertEquals(1, regex.match("dcd", "cd?***"));
        Assert.assertEquals(-1, regex.match("dcd", "cd***4"));
    }
}

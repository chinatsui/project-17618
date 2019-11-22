package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class RegexIITest {

    private RegexII regexII = new RegexII();

    @Test
    public void test() {
        Assert.assertTrue(regexII.match("abcdxx", "a*bcd?xx"));
        Assert.assertFalse(regexII.match("abcdxxa", "a*bcd?xx"));
        Assert.assertTrue(regexII.match("abcd", "a*bcd?**"));
        Assert.assertFalse(regexII.match("abcd", "a*bcd?**4"));
    }
}

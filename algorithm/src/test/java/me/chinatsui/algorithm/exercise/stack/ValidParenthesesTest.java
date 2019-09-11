package me.chinatsui.algorithm.exercise.stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

    private ValidParentheses vp = new ValidParentheses();

    @Test
    public void test() {
        Assert.assertTrue(vp.isValid("{}"));
        Assert.assertTrue(vp.isValid("{()}"));
        Assert.assertTrue(vp.isValid("{([])}"));
        Assert.assertFalse(vp.isValid("}{"));
        Assert.assertFalse(vp.isValid("{)(){}"));
        Assert.assertFalse(vp.isValid(")"));
    }
}

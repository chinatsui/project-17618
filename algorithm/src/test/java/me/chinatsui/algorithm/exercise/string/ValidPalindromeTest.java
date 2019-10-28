package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeTest {

    private ValidPalindrome vp = new ValidPalindrome();

    @Test
    public void test() {
        Assert.assertTrue(vp.check("A man, a plan, a canal: Panama"));
        Assert.assertFalse(vp.check("race a car"));
    }
}

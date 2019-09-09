package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {

    private LongestPalindrome lp = new LongestPalindrome();

    @Test
    public void test() {
        Assert.assertEquals("abba", lp.resolve("asexxabbaeeef"));
    }
}

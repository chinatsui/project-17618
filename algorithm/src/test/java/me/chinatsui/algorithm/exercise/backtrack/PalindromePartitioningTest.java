package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioningTest {

    private PalindromePartitioning palindromePartitioning = new PalindromePartitioning();

    @Test
    public void test() {
        Assert.assertEquals(2, palindromePartitioning.partition("aab").size());
    }
}

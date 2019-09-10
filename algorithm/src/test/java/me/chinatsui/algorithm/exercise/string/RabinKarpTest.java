package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class RabinKarpTest {

    private RabinKarp rk = new RabinKarp();

    @Test
    public void test_search_when_text_contains_pattern() {
        char[] s1 = "aaaaaabbbbbb".toCharArray();
        char[] s2 = "aabb".toCharArray();
        Assert.assertEquals(4, rk.search(s1, s2));
    }

    @Test
    public void test_search_when_text_not_contains_pattern() {
        char[] s1 = "aaaaaabbbbbb".toCharArray();
        char[] s2 = "aabc".toCharArray();
        Assert.assertEquals(-1, rk.search(s1, s2));
    }
}

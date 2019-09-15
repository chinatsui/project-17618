package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class KMPSearchTest {

    private KMPSearch kmps = new KMPSearch();

    @Test
    public void test() {
        char[] text = "ababaeabac".toCharArray();
        char[] pattern = "baeab".toCharArray();
        Assert.assertEquals(3, kmps.search(text, pattern));
    }
}

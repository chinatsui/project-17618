package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class TransportCowsTest {

    @Test
    public void test() {
        TransportCows tc = new TransportCows(6, 3, 2, new int[]{1, 1, 10, 14, 4, 3});
        Assert.assertEquals(4, tc.resolve());
    }
}

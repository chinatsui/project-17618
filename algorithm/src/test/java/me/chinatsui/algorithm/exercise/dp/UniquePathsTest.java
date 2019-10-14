package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {

    private UniquePaths up = new UniquePaths();

    @Test
    public void test() {
        Assert.assertEquals(3, up.resolve(3, 2));
        Assert.assertEquals(28, up.resolve(7, 3));
    }
}

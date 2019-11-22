package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class SubsetsTest {

    private Subsets subsets = new Subsets();

    @Test
    public void test() {
        Assert.assertEquals(8, subsets.subsets(new int[]{1, 2, 3}).size());
    }
}

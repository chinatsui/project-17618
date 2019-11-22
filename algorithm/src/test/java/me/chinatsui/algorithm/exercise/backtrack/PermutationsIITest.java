package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class PermutationsIITest {

    private PermutationsII permutationsII = new PermutationsII();

    @Test
    public void test() {
        Assert.assertEquals(3, permutationsII.permute(new int[]{1, 1, 2}).size());
    }
}

package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class PermutationsTest {

    private Permutations permutations = new Permutations();

    @Test
    public void test() {
        Assert.assertEquals(6, permutations.permute(new int[]{1, 2, 3}).size());
    }
}

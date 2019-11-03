package me.chinatsui.algorithm.exercise.array;


import java.util.List;

import me.chinatsui.algorithm.exercise.backtrack.Permutations;
import org.junit.Assert;
import org.junit.Test;

public class PermutationsTest {

    private Permutations p = new Permutations();

    @Test
    public void test() {
        List<List<Integer>> actual = p.permute(new int[]{1, 2, 3});
        Assert.assertEquals(6, actual.size());
    }
}

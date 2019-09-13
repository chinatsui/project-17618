package me.chinatsui.algorithm.exercise.array;

import me.chinatsui.algorithm.exercise.backtrack.PermutationsII;
import org.junit.Assert;
import org.junit.Test;

public class PermutationsIITest {

    PermutationsII p = new PermutationsII();

    @Test
    public void test() {
        Assert.assertEquals(3, p.permute(new int[]{1, 1, 2}).size());
    }
}

package me.chinatsui.algorithm.exercise.greedy;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameIITest {

    private JumpGameII jumpGameII = new JumpGameII();

    @Test
    public void test() {
        Assert.assertEquals(2, jumpGameII.jump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(3, jumpGameII.jump(new int[]{1, 3, 2, 4, 5, 6, 8}));
    }
}

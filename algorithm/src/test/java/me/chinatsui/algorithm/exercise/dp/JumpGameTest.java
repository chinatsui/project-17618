package me.chinatsui.algorithm.exercise.dp;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameTest {

    private JumpGame jg = new JumpGame();

    @Test
    public void test() {
        Assert.assertTrue(jg.canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(jg.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}

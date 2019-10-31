package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class LCAIITest {

    private LCAII lcaii = new LCAII();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        Assert.assertEquals(6, lcaii.resolve(root, 2, 8).val);
    }
}

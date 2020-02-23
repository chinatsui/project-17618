package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class MaximumPathSumTest {

    private MaximumPathSum mps = new MaximumPathSum();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{-10, 9, 20, null, null, 15, 7});
        Assert.assertEquals(42, mps.maxPathSum(root));
    }
}

package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class MaximumPathSumTest {

    private MaximumPathSum mps = new MaximumPathSum();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{1,2,3});
        Assert.assertEquals(42, mps.maxPathSum(root));
    }
}

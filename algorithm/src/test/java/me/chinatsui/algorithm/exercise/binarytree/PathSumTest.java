package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class PathSumTest {

    private PathSum ps = new PathSum();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        Assert.assertTrue(ps.hasPathSum(root, 22));
        Assert.assertFalse(ps.hasPathSum(root, 23));
    }
}

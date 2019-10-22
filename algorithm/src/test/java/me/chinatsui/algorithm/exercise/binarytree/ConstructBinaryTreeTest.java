package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class ConstructBinaryTreeTest {

    private ConstructBinaryTree cbt = new ConstructBinaryTree();

    @Test
    public void test() {
        TreeNode root = cbt.construct(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Assert.assertArrayEquals(new Integer[]{3, 9, 20, null, null, 15, 7}, TreeNodes.serialize(root));
    }
}

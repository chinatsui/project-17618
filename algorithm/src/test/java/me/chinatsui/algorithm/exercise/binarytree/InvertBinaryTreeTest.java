package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class InvertBinaryTreeTest {

    private InvertBinaryTree ibt = new InvertBinaryTree();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode inverted = ibt.invert(root);
        Assert.assertArrayEquals(new Integer[]{4, 7, 2, 9, 6, 3, 1}, TreeNodes.serialize(inverted));
    }
}

package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreePreorderTraversalTest {

    private BinaryTreePreorderTraversal btpt = new BinaryTreePreorderTraversal();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserializeByLevelTraversal(new Integer[]{1, 2, 3, 4, null, null, 5});
        List<Integer> history = btpt.traverse(root);
        Assert.assertArrayEquals(new int[]{1, 2, 4, 3, 5}, history.stream().mapToInt(i -> i).toArray());
    }
}

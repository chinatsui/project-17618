package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeInorderTraversalTest {

    private BinaryTreeInorderTraversal btir = new BinaryTreeInorderTraversal();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserializeByLevelTraversal(new Integer[]{1, 2, 3, 4, null, null, 5});
        List<Integer> history = btir.traverse(root);
        Assert.assertArrayEquals(new int[]{4, 2, 1, 3, 5}, history.stream().mapToInt(i -> i).toArray());
    }
}

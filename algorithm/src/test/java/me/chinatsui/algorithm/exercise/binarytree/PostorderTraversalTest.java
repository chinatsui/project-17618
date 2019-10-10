package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class PostorderTraversalTest {

    private PostorderTraversal btpt = new PostorderTraversal();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserializeByLevelTraversal(new Integer[]{1, 2, 3, 4, null, null, 5});
        List<Integer> history = btpt.traverse(root);
        Assert.assertArrayEquals(new int[]{4, 2, 5, 3, 1}, history.stream().mapToInt(i -> i).toArray());
    }
}

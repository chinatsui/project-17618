package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class LevelOrderTraversalTest {

    private LevelOrderTraversal lot = new LevelOrderTraversal();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{5, 6, 7, null, 32, null, 12, 11});
        List<Integer> trace = lot.traverse(root);
        Integer[] expected = new Integer[]{5, 6, 7, 32, 12, 11};
        Assert.assertArrayEquals(expected, trace.toArray());
    }
}

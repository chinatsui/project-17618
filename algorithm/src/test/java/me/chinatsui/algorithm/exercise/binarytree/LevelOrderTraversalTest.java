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
        List<List<Integer>> actual = lot.traverse(root);
        Assert.assertArrayEquals(new Integer[]{5}, actual.get(0).toArray(new Integer[1]));
        Assert.assertArrayEquals(new Integer[]{6, 7}, actual.get(1).toArray(new Integer[2]));
        Assert.assertArrayEquals(new Integer[]{32, 12}, actual.get(2).toArray(new Integer[2]));
        Assert.assertArrayEquals(new Integer[]{11}, actual.get(3).toArray(new Integer[1]));
    }
}

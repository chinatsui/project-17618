package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class ZigzagOrderTraversalTest {

    private ZigzagOrderTraversal zot = new ZigzagOrderTraversal();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> res = zot.traverse(root);
        Assert.assertEquals(3, res.size());
        Assert.assertArrayEquals(new Integer[]{3}, res.get(0).toArray(new Integer[1]));
        Assert.assertArrayEquals(new Integer[]{20, 9}, res.get(1).toArray(new Integer[2]));
        Assert.assertArrayEquals(new Integer[]{15, 7}, res.get(2).toArray(new Integer[2]));
    }
}

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
        List<Integer> res = zot.traverse(root);
        Integer[] expected = new Integer[]{3, 20, 9, 15, 7};
        Assert.assertArrayEquals(expected, res.toArray());
    }
}

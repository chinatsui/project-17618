package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class ColumnOrderTraversalTest {

    private ColumnOrderTraversal cot = new ColumnOrderTraversal();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserializeByLevelTraversal(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<Integer> trace = cot.traverse(root);
        Integer[] expected = new Integer[]{9, 3, 15, 20, 7};
        Assert.assertArrayEquals(expected, trace.toArray());
    }
}

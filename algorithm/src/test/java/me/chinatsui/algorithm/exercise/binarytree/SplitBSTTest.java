package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class SplitBSTTest {

    private SplitBST splitBST = new SplitBST();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{4, 2, 6, 1, 3, 5, 7});
        TreeNode[] nodes = splitBST.splitBST(root, 2);
        Assert.assertArrayEquals(new Integer[]{2, 1}, TreeNodes.serialize(nodes[0]));
        Assert.assertArrayEquals(new Integer[]{4, 3, 6, null, null, 5, 7}, TreeNodes.serialize(nodes[1]));
    }
}

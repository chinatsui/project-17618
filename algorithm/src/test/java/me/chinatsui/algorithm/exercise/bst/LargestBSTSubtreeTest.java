package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.exercise.bst.LargestBSTSubtree;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class LargestBSTSubtreeTest {

    private LargestBSTSubtree lbsts = new LargestBSTSubtree();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(
                new Integer[]{50, 30, 60, 5, 20, 45, 70, null, null, null, null, null, null, 65, 80});
        Assert.assertEquals(5, lbsts.largestBSTSubtree(root));
    }
}

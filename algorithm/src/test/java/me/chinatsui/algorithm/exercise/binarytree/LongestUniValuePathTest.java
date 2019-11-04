package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class LongestUniValuePathTest {

    private LongestUniValuePath luvp = new LongestUniValuePath();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{5, 4, 5, 1, 1, 5});
        Assert.assertEquals(2, luvp.find(root));
    }
}

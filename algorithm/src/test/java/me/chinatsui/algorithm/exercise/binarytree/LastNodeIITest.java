package me.chinatsui.algorithm.exercise.binarytree;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class LastNodeIITest {

    private LastNodeII lnii = new LastNodeII();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        Assert.assertEquals(11, lnii.find(root).val);
    }
}

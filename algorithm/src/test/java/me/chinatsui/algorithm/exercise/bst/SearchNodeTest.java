package me.chinatsui.algorithm.exercise.bst;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class SearchNodeTest {

    private SearchNode sn = new SearchNode();

    @Test
    public void test() {
        TreeNode root = TreeNodes.getBinarySearchTree();
        Assert.assertEquals(7, sn.search(root, 7).val);
    }
}

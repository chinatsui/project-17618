package me.chinatsui.algorithm.exercise.bst;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class InsertNodeTest {

    private SearchNode sn = new SearchNode();
    private InsertNode in = new InsertNode();
    private ValidateBST validateBST = new ValidateBST();

    @Test
    public void test() {
        TreeNode root = TreeNodes.getBinarySearchTree();
        root = in.insert(root, 11);
        Assert.assertTrue(validateBST.validate(root));
        Assert.assertEquals(11, sn.search(root, 11).val);
    }
}

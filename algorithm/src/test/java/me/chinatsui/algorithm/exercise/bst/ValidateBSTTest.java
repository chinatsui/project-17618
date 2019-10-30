package me.chinatsui.algorithm.exercise.bst;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.util.TreeNodes;

public class ValidateBSTTest {

    private ValidateBST vbst = new ValidateBST();

    @Test
    public void test() {
        Assert.assertTrue(vbst.validate(TreeNodes.getBinarySearchTree()));
        Assert.assertFalse(vbst.validate(TreeNodes.getFullBinaryTree()));
    }
}

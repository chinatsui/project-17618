package me.chinatsui.algorithm.exercise.bst;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.util.TreeNodes;

public class ValidationTest {

    private Validation vbst = new Validation();

    @Test
    public void test() {
        Assert.assertTrue(vbst.validate(TreeNodes.getBinarySearchTree()));
        Assert.assertFalse(vbst.validate(TreeNodes.getFullBinaryTree()));
    }
}

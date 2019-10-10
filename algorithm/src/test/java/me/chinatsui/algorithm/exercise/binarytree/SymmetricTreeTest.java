package me.chinatsui.algorithm.exercise.binarytree;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.util.TreeNodes;

public class SymmetricTreeTest {

    private SymmetricTree st = new SymmetricTree();

    @Test
    public void test() {
        Assert.assertTrue(st.check(TreeNodes.getSymmetricTree()));
        Assert.assertFalse(st.check(TreeNodes.getBinarySearchTree()));
    }
}

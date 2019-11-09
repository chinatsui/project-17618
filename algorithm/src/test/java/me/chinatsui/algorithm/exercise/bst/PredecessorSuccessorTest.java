package me.chinatsui.algorithm.exercise.bst;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class PredecessorSuccessorTest {

    private PredecessorSuccessor ps = new PredecessorSuccessor();

    @Test
    public void test() {
        TreeNode root = TreeNodes.getBinarySearchTree();
        PredecessorSuccessor.Result res = ps.resolve(root, 16);
        Assert.assertEquals(15, res.getPredecessor().val);
        Assert.assertEquals(19, res.getSuccessor().val);
    }
}

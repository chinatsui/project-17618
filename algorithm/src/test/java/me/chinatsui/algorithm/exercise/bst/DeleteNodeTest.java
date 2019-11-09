package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeTest {

    private DeleteNode dnibst = new DeleteNode();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode actual = dnibst.deleteNode(root, 3);
        Assert.assertArrayEquals(new Integer[]{5, 4, 6, 2, null, null, 7}, TreeNodes.serialize(actual));
    }
}

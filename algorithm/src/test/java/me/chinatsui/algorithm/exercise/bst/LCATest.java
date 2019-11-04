package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class LCATest {

    private LCA lca = new LCA();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        Assert.assertEquals(6, lca.resolve(root, 2, 8).val);
    }
}

package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class LCATest {

    private LCA lca = new LCA();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{4, 3, 7, null, null, 5, 6});
        Assert.assertEquals(4, lca.resolve(root, 3, 5).val);
    }
}

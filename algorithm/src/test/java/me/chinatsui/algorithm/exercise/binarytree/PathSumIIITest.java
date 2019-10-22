package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class PathSumIIITest {

    private PathSumIII psiii = new PathSumIII();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        Assert.assertEquals(3, psiii.pathSum(root, 8));
    }
}

package me.chinatsui.algorithm.exercise.binarytree;

import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;
import org.junit.Assert;
import org.junit.Test;

public class PathSumIITest {

    private PathSumII psii = new PathSumII();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> res = psii.pathSum(root, 22);
        Assert.assertArrayEquals(new Integer[]{5, 4, 11, 2}, res.get(0).toArray(new Integer[res.size()]));
        Assert.assertArrayEquals(new Integer[]{5, 8, 4, 5}, res.get(1).toArray(new Integer[res.size()]));
    }
}

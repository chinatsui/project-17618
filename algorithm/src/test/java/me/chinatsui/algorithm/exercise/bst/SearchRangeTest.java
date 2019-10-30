package me.chinatsui.algorithm.exercise.bst;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class SearchRangeTest {

    private SearchRange sr = new SearchRange();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{20, 8, 22, 4, 12});
        Assert.assertArrayEquals(new Integer[]{12, 20, 22}, sr.searchRange(root, 10, 22).toArray(new Integer[3]));
    }
}

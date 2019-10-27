package me.chinatsui.algorithm.exercise.binarytree;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class FlattenToLinkedListTest {

    private FlattenToLinkedList ftll = new FlattenToLinkedList();

    @Test
    public void test() {
        TreeNode root = TreeNodes.deserialize(new Integer[]{1, 2, 5, 3, 4, null, 6});
        ftll.flatten(root);
        int i = 1;
        while (root != null) {
            Assert.assertEquals(i++, root.val);
            root = root.right;
        }
    }
}

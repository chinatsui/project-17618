package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

public class SplitTree {

    public static TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode dummySm = new TreeNode(0);
        TreeNode curSm = dummySm;
        TreeNode dummyLg = new TreeNode(0);
        TreeNode curLg = dummyLg;

        while (root != null) {
            if (root.val <= V) {
                curSm.right = root;
                curSm = root;
                root = root.right;
                curSm.right = null;
            } else {
                curLg.left = root;
                curLg = root;
                root = root.left;
                curLg.left = null;
            }
        }
        return new TreeNode[]{dummySm.right, dummyLg.left};
    }

}

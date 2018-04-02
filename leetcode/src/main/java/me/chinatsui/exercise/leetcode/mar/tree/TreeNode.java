package me.chinatsui.exercise.leetcode.mar.tree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int v) {
        val = v;
    }

    public String toString() {
        return String.valueOf(val);
    }

    public boolean isLeaf() {
        return left == null && right == null ? true : false;
    }

    public static TreeNode getBinarySearchTree() {
        TreeNode root = new TreeNode(16);

        root.left = new TreeNode(8);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(13);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(15);

        return root;
    }

    public static TreeNode getSymmetricTree() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);

        return root;
    }

    public static TreeNode getFullBinaryTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(10);

        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(12);

        root.right.left.left = new TreeNode(13);
        root.right.left.right = new TreeNode(14);

        root.right.right.left = new TreeNode(15);
        root.right.right.right = new TreeNode(16);

        return root;
    }

}

package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

public class Diameter {

    private int length;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return length;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        if (node.left == null && node.right == null) {
            return 0;
        }

        int left = dfs(node.left);
        left = left == -1 ? 0 : 1 + left;

        int right = dfs(node.right);
        right = right == -1 ? 0 : 1 + right;

        length = Math.max(length, left + right);
        return Math.max(left, right);
    }
}

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

        int left = dfs(node.left);
        left = left == -1 ? 0 : left + 1;

        int right = dfs(node.right);
        right = right == -1 ? 0 : right + 1;

        length = Math.max(length, left + right);

        return Math.max(left, right);
    }
}

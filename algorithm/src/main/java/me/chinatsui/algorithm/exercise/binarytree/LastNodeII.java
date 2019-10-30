package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * Given a perfect binary tree, get the last node. Expected time complexity is o(logN).
 * <p>
 * This implementation is based on recursion.
 */
public class LastNodeII {

    public TreeNode find(TreeNode root) {
        if (root == null) {
            return null;
        }

        int depth = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
            depth++;
        }

        return dfs(root, depth, 0);
    }

    private TreeNode dfs(TreeNode node, int depth, int tmp) {
        if (node == null) {
            return null;
        }

        if (node.right == null && node.left != null) {
            return node.left;
        }

        if (node.left == null && node.right == null && tmp == depth) {
            return node;
        }

        TreeNode target = dfs(node.right, depth, tmp + 1);

        if (target == null) {
            target = dfs(node.left, depth, tmp + 1);
        }

        return target;
    }
}

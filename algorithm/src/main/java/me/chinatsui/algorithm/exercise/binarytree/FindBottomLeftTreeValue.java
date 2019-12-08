package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode 513. Find Bottom Left Tree Value
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 *
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 */
public class FindBottomLeftTreeValue {

    private int level = -1;
    private int leftMost = -1;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0);
        return leftMost;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level > this.level) {
            this.level = level;
            this.leftMost = node.val;
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}

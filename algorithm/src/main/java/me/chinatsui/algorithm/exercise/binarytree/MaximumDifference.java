package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * GeeksForGeeks
 * <p>
 * Given a binary tree, we need to find maximum value we can get by subtracting value of node B from value of node A,
 * where A and B are two nodes of the binary tree and A is an ancestor of B. Expected time complexity is O(n).
 */
public class MaximumDifference {

    public int maxDiff(TreeNode root) {
        Result res = new Result();
        maxDiff(root, res);
        return res.val;
    }

    private int maxDiff(TreeNode node, Result res) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }

        int minVal = Math.min(maxDiff(node.left, res), maxDiff(node.right, res));
        res.val = Math.max(res.val, node.val - minVal);

        return Math.min(node.val, minVal);
    }

    static class Result {
        int val = Integer.MIN_VALUE;
    }
}

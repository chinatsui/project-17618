package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

public class MaximumDifferenceAbs {

    private int res = Integer.MIN_VALUE;

    public int maxDiffAbs(TreeNode root) {
        dfs(root);
        return res;
    }

    private Pair dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return new Pair(node.val, node.val);
        }

        Pair left = dfs(node.left), right = dfs(node.right);

        int minVal, maxVal;
        if (left != null && right != null) {
            minVal = Math.min(left.minVal, right.minVal);
            maxVal = Math.max(left.maxVal, right.maxVal);
        } else if (left != null) {
            minVal = left.minVal;
            maxVal = left.maxVal;
        } else {
            minVal = right.minVal;
            maxVal = right.maxVal;
        }

        res = Math.max(res, Math.max(Math.abs(node.val - minVal), Math.abs(node.val - maxVal)));

        return new Pair(Math.min(node.val, minVal), Math.max(node.val, maxVal));
    }

    static class Pair {
        int minVal;
        int maxVal;

        Pair(int minVal, int maxVal) {
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }
}

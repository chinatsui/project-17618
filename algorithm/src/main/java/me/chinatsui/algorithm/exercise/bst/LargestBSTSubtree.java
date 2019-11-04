package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-333
 *
 * Given a Binary Tree, write a function that returns the size of the largest subtree
 * which is also a Binary Search Tree (BST).
 *
 * If the complete Binary Tree is BST, then return the size of whole tree.
 *
 * Example:
 * Input:
 *       5
 *     /  \
 *    2    4
 *  /  \
 * 1    3
 * Output: 3
 * The following subtree is the maximum size BST subtree
 *    2
 *  /  \
 * 1    3
 *
 *
 * Example:
 * Input:
 *        50
 *      /    \
 *   30       60
 *  /  \     /  \
 * 5   20   45    70
 *               /  \
 *             65    80
 * Output: 5
 * The following subtree is the maximum size BST subtree
 *       60
 *      /  \
 *    45    70
 *         /  \
 *       65    80
 */
public class LargestBSTSubtree {

    private int maxSize = 1;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return maxSize;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Result leftRes = dfs(node.left);
        Result rightRes = dfs(node.right);

        Result res = new Result(1, true);
        res.minVal = node.val;
        res.maxVal = node.val;

        if (leftRes != null && leftRes.isBST && leftRes.maxVal < node.val) {
            res.minVal = leftRes.minVal;
            res.size += leftRes.size;
            maxSize = Math.max(maxSize, res.size);
        }

        if (rightRes != null && rightRes.isBST && rightRes.minVal >= node.val) {
            res.maxVal = rightRes.maxVal;
            res.size += rightRes.size;
            maxSize = Math.max(maxSize, res.size);
        }

        return res;
    }

    static class Result {
        int size;
        boolean isBST;
        int minVal = Integer.MIN_VALUE;
        int maxVal = Integer.MAX_VALUE;

        Result(int size, boolean isBST) {
            this.size = size;
            this.isBST = isBST;
        }
    }
}

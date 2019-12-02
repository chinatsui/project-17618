package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LintCode 596. Minimum Subtree
 * <p>
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * <p>
 * Example 1:
 * Input:
 * {1,-5,2,1,2,-4,-5}
 * Output:1
 * Explanation:
 * The tree is look like this:
 * 1
 * /   \
 * -5     2
 * / \   /  \
 * 1   2 -4  -5
 * The sum of whole tree is minimum, so return the root.
 * <p>
 * Example 2:
 * Input:
 * {1}
 * Output:1
 * Explanation:
 * The tree is look like this:
 * 1
 * There is one and only one subtree in the tree. So we return 1.
 */
public class MinimumSubtree {

    private int minSum = Integer.MAX_VALUE;
    private TreeNode minNode;

    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return minNode;
        }

        traverse(root);
        return minNode;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = traverse(node.left);
        int rightSum = traverse(node.right);
        int curSum = node.val + leftSum + rightSum;

        if (curSum < minSum) {
            minSum = curSum;
            minNode = node;
        }

        return curSum;
    }
}

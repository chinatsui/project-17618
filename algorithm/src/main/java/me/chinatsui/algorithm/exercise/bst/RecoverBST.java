package me.chinatsui.algorithm.exercise.bst;

import java.util.Stack;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode 99. Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Example 1:
 * Input: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 *
 * Example 2:
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * Follow up:
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        pushNodes(root, stack);

        TreeNode prev = null, large = null, small = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (prev != null && prev.val > node.val) {
                if (large == null) {
                    large = prev;
                }
                small = node;
            }

            prev = node;
            pushNodes(node.right, stack);
        }

        int tmp = large.val;
        large.val = small.val;
        small.val = tmp;
    }

    private void pushNodes(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

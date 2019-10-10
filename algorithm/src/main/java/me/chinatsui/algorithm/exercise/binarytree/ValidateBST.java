package me.chinatsui.algorithm.exercise.binarytree;

import java.util.Stack;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-98
 *
 * Given a binary tree, determine if it is a valid binary contains tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary contains trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBST {

    public boolean validate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        pushNodes(stack, root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null && prev.val >= cur.val) {
                return false;
            } else {
                prev = cur;
                pushNodes(stack, cur.right);
            }
        }

        return true;
    }

    private void pushNodes(Stack<TreeNode> stack, TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

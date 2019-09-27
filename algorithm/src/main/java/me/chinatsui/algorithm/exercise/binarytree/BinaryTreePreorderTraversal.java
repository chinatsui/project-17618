package me.chinatsui.algorithm.exercise.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-144
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * <p>
 * Output: [1,2,3]
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> traverse(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return res;
    }
}

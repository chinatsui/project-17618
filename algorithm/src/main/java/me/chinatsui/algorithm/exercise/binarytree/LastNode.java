package me.chinatsui.algorithm.exercise.binarytree;

import java.util.Stack;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * Given a perfect binary tree, get the last node. Expected time complexity is o(logN).
 * <p>
 * This implementation is based on iteration.
 */
public class LastNode {

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

        cur = root;
        Stack<TreeNode> stack = new Stack<>();
        int temp = 0;
        while (cur.right != null) {
            stack.push(cur);
            cur = cur.right;
            temp++;
        }

        if (temp == depth) {
            return cur;
        } else if (cur.left != null) {
            return cur.left;
        }

        while (!stack.isEmpty()) {
            if (cur == stack.peek().right) {
                cur = stack.peek().left;
            } else {
                cur = stack.pop();
                temp--;
                continue;
            }

            while (cur.right != null) {
                stack.push(cur);
                cur = cur.right;
                temp++;
            }

            if (temp == depth) {
                return cur;
            } else if (cur.left != null) {
                return cur.left;
            }
        }

        return root;
    }
}

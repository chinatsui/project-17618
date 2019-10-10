package me.chinatsui.algorithm.exercise.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-94
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 */
public class InorderTraversal {

    public List<Integer> traverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        pushNodes(stack, root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            pushNodes(stack, cur.right);
        }

        return res;
    }

    private void pushNodes(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

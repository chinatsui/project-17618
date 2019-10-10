package me.chinatsui.algorithm.exercise.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-145
 * <p>
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 */
public class PostorderTraversal {

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
            if (!stack.isEmpty() && stack.peek().right != cur) {
                pushNodes(stack, stack.peek().right);
            }
        }

        return res;
    }

    private void pushNodes(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left != null ? node.left : node.right;
        }
    }
}

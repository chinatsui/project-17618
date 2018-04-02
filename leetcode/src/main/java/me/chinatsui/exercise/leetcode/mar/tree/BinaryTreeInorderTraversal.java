package me.chinatsui.exercise.leetcode.mar.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public enum BinaryTreeInorderTraversal {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.traverseRecursively(TreeNode.getBinarySearchTree()));
        System.out.println(INSTANCE.traverseIteratively(TreeNode.getBinarySearchTree()));
    }

    public List<Integer> traverseRecursively(TreeNode root) {
        List<Integer> history = new ArrayList();
        traverse(root, history);
        return history;
    }

    private void traverse(TreeNode node, List<Integer> history) {
        if (node != null) {
            traverse(node.left, history);
            history.add(node.val);
            traverse(node.right, history);
        }
    }

    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> history = new ArrayList();

        TreeNode cur = root;
        Stack<TreeNode> s = new Stack();

        while (!s.empty() || cur != null) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }

            if (cur != null) {
                history.add(cur.val);
            }

            while (!s.empty() && cur == s.peek().right) {
                cur = s.pop();
            }

            if (!s.empty() && cur != s.peek().right) {
                history.add(s.peek().val);
            }

            if (s.empty()) {
                cur = null;
            } else {
                cur = s.peek().right;
            }
        }

        return history;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return true;
        }

        return node.isLeaf();
    }

}

package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public enum BinaryTreePostorderTraversal {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.traverseRecursively(BinaryTree.getBinarySearchTree()));
        System.out.println(INSTANCE.traverseIteratively(BinaryTree.getBinarySearchTree()));
    }

    public List<Integer> traverseRecursively(TreeNode root) {
        List<Integer> history = new ArrayList<>();
        traverse(root, history);
        return history;
    }

    private void traverse(TreeNode node, List<Integer> history) {
        if (node != null) {
            traverse(node.left, history);
            traverse(node.right, history);
            history.add(node.val);
        }
    }

    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> history = new ArrayList();

        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;

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
                history.add(cur.val);
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

        return node.left == null && node.right == null;
    }

}

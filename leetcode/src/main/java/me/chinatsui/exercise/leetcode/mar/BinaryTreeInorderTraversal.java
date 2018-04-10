package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public enum BinaryTreeInorderTraversal {

    INSTANCE;

    public static void main(String[] args) {
//        System.out.println(INSTANCE.traverseRecursively(BinaryTree.getBinarySearchTree()));
        System.out.println(INSTANCE.traverseIteratively(BinaryTree.getBinarySearchTree()));
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

        Stack<TreeNode> s = new Stack();

        while (!s.empty() || root != null) {
            while (!isLeaf(root)) {
                s.push(root);
                root = root.left;
            }

            if (root != null) {
                history.add(root.val);
            }

            while (!s.empty() && root == s.peek().right) {
                root = s.pop();
            }

            if (s.empty()) {
                root = null;
            } else {
                history.add(s.peek().val);
                root = s.peek().right;
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

package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public enum BinaryTreePreorderTraversal {

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
            history.add(node.val);
            traverse(node.left, history);
            traverse(node.right, history);
        }
    }

    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> history = new ArrayList();

        TreeNode cur = root;
        Stack<TreeNode> s = new Stack();

        while (!s.empty() || cur != null) {
            // iterate till the first left leaf.
            while (!isLeaf(cur)) {
                history.add(cur.val);
                s.push(cur);
                cur = cur.left;
            }

            if (cur != null) {
                history.add(cur.val);
            }

            while (!s.empty() && cur == s.peek().right) {
                cur = s.pop();
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

package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

import java.util.Stack;

public enum BSTCheck {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.isBST(TreeNodes.getBinarySearchTree()));
        System.out.println(INSTANCE.isBST(TreeNodes.getFullBinaryTree()));
    }

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        int min = Integer.MIN_VALUE;
        Stack<TreeNode> s = new Stack<>();
        while (!s.empty() || root != null) {
            while (!isLeaf(root)) {
                s.push(root);
                root = root.left;
            }

            if (root != null) {
                if (root.val > min) {
                    min = root.val;
                } else {
                    return false;
                }
            }

            while (!s.empty() && root == s.peek().right) {
                root = s.pop();
            }

            if (s.empty()) {
                root = null;
            } else {
                TreeNode parent = s.peek();
                if (parent.val > min) {
                    min = parent.val;
                } else {
                    return false;
                }
                root = parent.right;
            }
        }

        return true;
    }

    private boolean isLeaf(TreeNode node) {
        return node == null ? true : node.left == null && node.right == null;
    }

}

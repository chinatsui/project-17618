package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;

import java.util.Stack;

public class LargestBSTSubtree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);

        root.right.right = new TreeNode(7);

        System.out.println(new LargestBSTSubtree().largestBSTSubtree(root));
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int size = isBST(root);
        if (size > 0) {
            return size;
        } else {
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }
    }

    private int isBST(TreeNode node) {
        int min = Integer.MIN_VALUE;
        int size = 0;
        Stack<TreeNode> s = new Stack<>();
        while(!s.empty() || node != null) {
            while(!isLeaf(node)) {
                s.push(node);
                node = node.left;
            }

            if (node != null) {
                if (node.val > min) {
                    size++;
                    min = node.val;
                } else {
                    return 0;
                }
            }

            while(!s.empty() && node == s.peek().right) {
                node = s.pop();
            }

            if (s.empty()) {
                node = null;
            } else {
                if (s.peek().val > min) {
                    size++;
                    min = s.peek().val;
                } else {
                    return 0;
                }
                node = s.peek().right;
            }
        }

        return size;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return true;
        }
        return node.left == null && node.right == null;
    }

}

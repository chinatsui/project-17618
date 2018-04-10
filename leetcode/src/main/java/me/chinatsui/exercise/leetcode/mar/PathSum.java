package me.chinatsui.exercise.leetcode.mar;

import java.util.Stack;

public enum PathSum {

    INSTANCE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(INSTANCE.hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int curSum = 0;
        Stack<TreeNode> s = new Stack();
        while (!s.empty() || root != null) {
            while (!isLeaf(root)) {
                curSum += root.val;
                if (curSum == sum) {
                    return true;
                }
                s.push(root);
                root = root.left;
            }

            if (root != null) {
                curSum += root.val;
                if (curSum == sum) {
                    return true;
                }
            }

            while (!s.empty() && root == s.peek().right) {
                if (root != null) {
                    curSum -= root.val;
                }
                root = s.pop();
            }

            if (s.empty()) {
                root = null;
            } else {
                if (root != null) {
                    curSum -= root.val;
                }
                root = s.peek().right;
            }

        }

        return false;
    }

    private boolean isLeaf(TreeNode node) {
        return node == null ? true : node.left == null && node.right == null;
    }

}

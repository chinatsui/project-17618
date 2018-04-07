package me.chinatsui.exercise.leetcode.mar;

import java.util.Stack;

public enum BSTSerialization {

    INSTANCE;

    private static final String SPL = ",";

    public static void main(String[] args) {
        String data = INSTANCE.serialize(TreeNode.getBinarySearchTree());
        TreeNode root = INSTANCE.deserialize(data);
        System.out.println("Finished.");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder("");
        Stack<TreeNode> s = new Stack();

        while (!s.empty() || root != null) {
            while (!isLeaf(root)) {
                s.push(root);
                res.append(root.val + SPL);
                root = root.left;
            }

            if (root != null) {
                res.append(root.val + SPL);
            }

            while (!s.empty() && root == s.peek().right) {
                root = s.pop();
            }

            if (s.empty()) {
                root = null;
            } else {
                root = s.peek().right;
            }

        }

        return res.toString();
    }

    private boolean isLeaf(TreeNode node) {
        return node == null ? true : node.left == null && node.right == null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1) {
            return null;
        }

        String[] preorder = data.split(SPL);
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(String[] preorder, int start, int end) {
        if (start <= end) {
            int val = Integer.valueOf(preorder[start]);
            TreeNode root = new TreeNode(val);

            int split = -1;
            for (int i = start + 1; i <= end; i++ ) {
                if (val < Integer.valueOf(preorder[i])) {
                    split = i;
                    break;
                }
            }

            if (split != -1) {
                root.left = buildTree(preorder, start + 1, split - 1);
                root.right = buildTree(preorder, split, end);
            } else {
                root.left = buildTree(preorder, start + 1, end);
            }

            return root;
        } else {
            return null;
        }
    }

}

package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class ConvertToDLL {

    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        root = buildDLL(root);
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    private TreeNode buildDLL(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            TreeNode left = buildDLL(node.left);
            while (left.right != null) {
                left = left.right;
            }
            left.right = node;
            node.left = left;
        }

        if (node.right != null) {
            TreeNode right = buildDLL(node.right);
            while (right.left != null) {
                right = right.left;
            }
            node.right = right;
            right.left = node;
        }

        return node;
    }
}

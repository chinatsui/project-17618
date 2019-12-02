package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;
import me.chinatsui.algorithm.util.TreeNodes;

public class ConvertToDLL {

    public static void main(String[] args) {
        ConvertToDLL ctd = new ConvertToDLL();
        TreeNode bst = TreeNodes.getBinarySearchTree();
        TreeNode dll = ctd.convert(bst);
        System.out.println(1);
    }

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
            return node;
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

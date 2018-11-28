package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.util.BinaryTree;
import me.chinatsui.algorithm.util.TreeNode;

public enum DeleteNodeInBST {

    INSTANCE;

    public static void main(String[] args) {
        TreeNode bst = BinaryTree.getBinarySearchTree();
        INSTANCE.deleteNode(bst, 16);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = getMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }

        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}

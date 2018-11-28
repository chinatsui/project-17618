package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.BinaryTree;
import me.chinatsui.algorithm.util.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinarySearchTree();
        System.out.println(BinaryTree.serialize(root));
        TreeNode res = Solution.INSTANCE.invert(root);
        System.out.println(BinaryTree.serialize(res));
    }

    public enum Solution {
        INSTANCE;

        public TreeNode invert(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = this.invert(root.left);
            TreeNode right = this.invert(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}

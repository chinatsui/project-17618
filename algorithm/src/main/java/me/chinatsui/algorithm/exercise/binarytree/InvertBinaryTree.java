package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNodes.getBinarySearchTree();
        System.out.println(TreeNodes.serialize(root));
        TreeNode res = Solution.INSTANCE.invert(root);
        System.out.println(TreeNodes.serialize(res));
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

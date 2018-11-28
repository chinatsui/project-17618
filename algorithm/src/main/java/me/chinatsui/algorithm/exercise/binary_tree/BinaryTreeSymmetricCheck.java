package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.BinaryTree;
import me.chinatsui.algorithm.util.TreeNode;

public class BinaryTreeSymmetricCheck {


    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.isSymmetric(BinaryTree.getSymmetricTree()));
    }

    public enum Solution {
        INSTANCE;

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            return check(root.left, root.right);
        }

        private boolean check(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            if (left != null && right != null) {
                return left.val == right.val
                        && check(left.left, right.right)
                        && check(left.right, right.left);
            }

            return false;
        }
    }
}

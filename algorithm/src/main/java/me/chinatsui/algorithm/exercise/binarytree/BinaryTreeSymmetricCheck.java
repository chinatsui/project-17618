package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

public class BinaryTreeSymmetricCheck {


    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.isSymmetric(TreeNodes.getSymmetricTree()));
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

package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum BinaryTreeSymmetricCheck {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.isSymmetric(BinaryTree.getBinarySearchTree()));
        System.out.println(INSTANCE.isSymmetric(BinaryTree.getSymmetricTree()));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            return left.val == right.val
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }

        return false;
    }

}

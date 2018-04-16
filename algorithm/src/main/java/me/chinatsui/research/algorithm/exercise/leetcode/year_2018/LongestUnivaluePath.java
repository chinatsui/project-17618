package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum LongestUnivaluePath {

    INSTANCE;

    int max = 0;

    public static void main(String[] args) {
        Integer[] data = {5, 4, 5, 1, 1, 5};
        TreeNode root = BinaryTree.deserializeFromLevelOrder(data);
        int res = INSTANCE.longestUnivaluePath(root);
        System.out.println(res);
    }

    public int longestUnivaluePath(TreeNode root) {
        passDown(root);
        return max;
    }

    private int passDown(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = passDown(node.left);
        int right = passDown(node.right);

        if (node.left != null && node.val == node.left.val) {
            left = 1 + left;
        } else {
            left = 0;
        }

        if (node.right != null && node.val == node.right.val) {
            right = 1 + right;
        } else {
            right = 0;
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }

}

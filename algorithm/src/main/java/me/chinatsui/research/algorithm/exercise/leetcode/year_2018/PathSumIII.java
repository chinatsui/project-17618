package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum PathSumIII {

    INSTANCE;

    public static void main(String[] args) {
        // [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8;
        Integer[] levelOrder = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = BinaryTree.deserializeFromLevelOrder(levelOrder);
        System.out.println(INSTANCE.pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode node, int remain) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        int val = node.val;
        remain -= val;

        if (remain == 0) {
            count++;
        }

        count += dfs(node.left, remain) + dfs(node.right, remain);

        return count;
    }

}

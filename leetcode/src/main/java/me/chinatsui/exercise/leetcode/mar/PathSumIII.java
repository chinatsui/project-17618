package me.chinatsui.exercise.leetcode.mar;

public enum PathSumIII {

    INSTANCE;

    public static void main(String[] args) {
        // [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8;

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return res;
        if (sum == root.val)
            res++;
        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        return res;
    }

}

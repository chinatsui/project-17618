package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.HashMap;

public enum PathSumIII2 {

    INSTANCE;

    public static void main(String[] args) {
        Integer[] levelOrder = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = BinaryTree.deserializeFromLevelOrder(levelOrder);
        System.out.println(INSTANCE.pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return traverse(root, 0, sum, preSum);
    }

    public int traverse(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += traverse(root.left, currSum, target, preSum) + traverse(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

}
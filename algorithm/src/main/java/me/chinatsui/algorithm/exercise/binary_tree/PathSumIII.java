package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    public static void main(String[] args) {
        // [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8;
        Integer[] levelOrder = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = BinaryTree.deserializeFromLevelOrder(levelOrder);
        System.out.println(Solution.INSTANCE.pathSum(root, 8));
    }

    public enum Solution {
        INSTANCE;

        public int pathSum(TreeNode root, int sum) {
            Map<Integer, Integer> cache = new HashMap<>();
            cache.put(0, 1);
            return dfs(root, 0, sum, cache);
        }

        private int dfs(TreeNode node, int curSum, int sum, Map<Integer, Integer> cache) {
            if (node == null) {
                return 0;
            }

            curSum += node.val;
            int cnt = cache.getOrDefault(curSum - sum, 0);

            cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);
            cnt += dfs(node.left, curSum, sum, cache);
            cnt += dfs(node.right, curSum, sum, cache);
            cache.put(curSum, cache.get(curSum) - 1);

            return cnt;
        }
    }
}



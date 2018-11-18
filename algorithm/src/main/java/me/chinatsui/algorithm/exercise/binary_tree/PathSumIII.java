package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.HashMap;

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

    public enum Solution2 {
        INSTANCE;

        public int pathSum_2(TreeNode root, int sum) {
            HashMap<Integer, Integer> preSum = new HashMap();
            preSum.put(0, 1);
            return dfs_2(root, 0, sum, preSum);
        }

        public int dfs_2(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
            if (root == null) {
                return 0;
            }

            currSum += root.val;
            int res = preSum.getOrDefault(currSum - target, 0);
            preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
            res += dfs_2(root.left, currSum, target, preSum) + dfs_2(root.right, currSum, target, preSum);
            preSum.put(currSum, preSum.get(currSum) - 1);
            return res;
        }
    }
}



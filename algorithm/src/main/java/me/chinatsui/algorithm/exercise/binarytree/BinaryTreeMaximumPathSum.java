package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        Integer[] data = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNodes.deserializeByLevelTraversal(data);
        System.out.println(Solution.INSTANCE.maxPathSum(root));
    }

    public enum Solution {
        INSTANCE;

        public int maxPathSum(TreeNode root) {
            int[] res = {Integer.MIN_VALUE};
            dfs(root, res);
            return res[0];
        }

        private int dfs(TreeNode node, int[] res) {
            if (node == null) {
                return 0;
            }

            int left = Math.max(0, dfs(node.left, res));
            int right = Math.max(0, dfs(node.right, res));

            int cur = node.val + left + right;
            res[0] = Math.max(res[0], cur);

            return node.val + Math.max(left, right);
        }
    }
}

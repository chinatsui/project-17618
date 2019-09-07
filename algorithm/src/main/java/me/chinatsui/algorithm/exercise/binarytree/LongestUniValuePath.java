package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

public class LongestUniValuePath {

    public static void main(String[] args) {
        Integer[] data = {5, 4, 5, 1, 1, 5};
        TreeNode root = TreeNodes.deserializeByLevelTraversal(data);
        int res = Solution.INSTANCE.longestUniValuePath(root);
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;

        int max = 0;

        public int longestUniValuePath(TreeNode root) {
            dfs(root);
            return max;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = dfs(node.left);
            int right = dfs(node.right);

            if (node.left != null && node.left.val == node.val) {
                left++;
            } else {
                left = 0;
            }

            if (node.right != null && node.right.val == node.val) {
                right++;
            } else {
                right = 0;
            }

            max = Math.max(max, left + right);

            return Math.max(left, right);
        }
    }
}

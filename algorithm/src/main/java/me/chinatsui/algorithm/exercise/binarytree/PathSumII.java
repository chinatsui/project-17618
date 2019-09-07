package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class PathSumII {

    public enum Solution {
        INSTANCE;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            this.dfs(root, sum, new ArrayList<>(), res);
            return res;
        }

        private void dfs(TreeNode node, int sum, List<Integer> cur, List<List<Integer>> res) {
            if (node == null) {
                return;
            }

            if (node.left == null && node.right == null) {
                if (node.val == sum) {
                    List<Integer> tmp = new ArrayList<>(cur);
                    tmp.add(node.val);
                    res.add(tmp);
                }
                return;
            }

            List<Integer> tmp = new ArrayList<>(cur);
            tmp.add(node.val);
            dfs(node.left, sum - node.val, tmp, res);
            dfs(node.right, sum - node.val, tmp, res);
        }
    }
}

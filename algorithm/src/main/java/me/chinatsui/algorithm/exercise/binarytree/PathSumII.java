package me.chinatsui.algorithm.exercise.binarytree;

import java.util.ArrayList;
import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode 113 - PathSumII
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void traverse(TreeNode node, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        cur.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<>(cur));
        } else {
            traverse(node.left, sum - node.val, cur, res);
            traverse(node.right, sum - node.val, cur, res);
        }
        cur.remove(cur.size() - 1);
    }
}

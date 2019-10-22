package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode-437
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return traverse(root, sum, cache, 0);
    }

    private int traverse(TreeNode node, int sum, Map<Integer, Integer> cache, int prevSum) {
        if (node == null) {
            return 0;
        }

        int curSum = prevSum + node.val;

        // use sum subtraction to detect there exists a sum path from one node to current node.
        int cnt = cache.getOrDefault(curSum - sum, 0);

        // put curSum for future subtraction to check sum path.
        cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);
        cnt += traverse(node.left, sum, cache, curSum);
        cnt += traverse(node.right, sum, cache, curSum);
        cache.put(curSum, cache.get(curSum) - 1);

        return cnt;
    }
}



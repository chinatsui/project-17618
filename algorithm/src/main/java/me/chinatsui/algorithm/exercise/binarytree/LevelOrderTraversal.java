package me.chinatsui.algorithm.exercise.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-102
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrderTraversal {

    public List<Integer> traverse(TreeNode root) {
        Map<Integer, List<Integer>> traceMap = new TreeMap<>();
        traverse(root, traceMap, 0);
        List<Integer> res = new ArrayList<>();
        traceMap.forEach((k,v) -> res.addAll(v));
        return res;
    }

    private void traverse(TreeNode node, Map<Integer, List<Integer>> traceMap, int row) {
        if (node == null) {
            return;
        }

        List<Integer> trace;
        if (traceMap.containsKey(row)) {
            trace = traceMap.get(row);
            trace.add(node.val);
        } else {
            trace = new ArrayList<>();
            trace.add(node.val);
            traceMap.put(row, trace);
        }

        traverse(node.left, traceMap, row + 1);
        traverse(node.right, traceMap, row + 1);
    }
}

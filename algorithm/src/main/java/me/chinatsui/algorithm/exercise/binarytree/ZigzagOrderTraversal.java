package me.chinatsui.algorithm.exercise.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-103
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagOrderTraversal {

    public List<Integer> traverse(TreeNode root) {
        Map<Integer, LinkedList<Integer>> traceMap = new TreeMap<>();
        traverse(root, traceMap, 0);
        List<Integer> res = new ArrayList<>();
        traceMap.forEach((k,v) -> res.addAll(v));
        return res;
    }

    private void traverse(TreeNode root, Map<Integer, LinkedList<Integer>> traceMap, int row) {
        if (root == null) {
            return;
        }

        LinkedList<Integer> trace;
        if (traceMap.containsKey(row)) {
            trace = traceMap.get(row);
        } else {
            trace = new LinkedList<>();
            traceMap.put(row, trace);
        }

        if (row % 2 == 0) {
            trace.offer(root.val);
        } else {
            trace.push(root.val);
        }

        traverse(root.left, traceMap, row + 1);
        traverse(root.right, traceMap, row + 1);
    }
}

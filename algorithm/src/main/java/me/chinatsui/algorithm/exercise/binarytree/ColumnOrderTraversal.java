package me.chinatsui.algorithm.exercise.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import me.chinatsui.algorithm.entity.TreeNode;

public class ColumnOrderTraversal {

    public List<Integer> traverse(TreeNode root) {
        Map<Integer, List<Integer>> traceMap = new TreeMap<>();
        traverse(root, traceMap, 0);
        List<Integer> res = new ArrayList<>();
        traceMap.forEach((k, v) -> res.addAll(v));
        return res;
    }

    private void traverse(TreeNode node, Map<Integer, List<Integer>> traceMap, int column) {
        if (node == null) {
            return;
        }

        List<Integer> trace;
        if (traceMap.containsKey(column)) {
            trace = traceMap.get(column);
        } else {
            trace = new ArrayList<>();
            traceMap.put(column, trace);
        }

        trace.add(node.val);
        traverse(node.left, traceMap, column - 1);
        traverse(node.right, traceMap, column + 1);
    }
}

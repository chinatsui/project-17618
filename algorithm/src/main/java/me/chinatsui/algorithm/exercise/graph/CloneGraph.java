package me.chinatsui.algorithm.exercise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {

    private Set<UndirectedGraphNode> visited = new HashSet();
    private Map<UndirectedGraphNode, UndirectedGraphNode> copyMap = new HashMap();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copyMap.put(node, copy);
        dfs(node, copy);
        return copy;
    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode copy) {
        if (node != null && !visited.contains(node)) {
            visited.add(node);
            for (UndirectedGraphNode n : node.neighbors) {
                UndirectedGraphNode copyNeighbor;
                if (copyMap.containsKey(n)) {
                    copyNeighbor = copyMap.get(n);
                    copy.neighbors.add(copyNeighbor);
                } else {
                    copyNeighbor = new UndirectedGraphNode(n.label);
                    copy.neighbors.add(copyNeighbor);
                    copyMap.put(n, copyNeighbor);
                }
                dfs(n, copyNeighbor);
            }
        }
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    ;

}

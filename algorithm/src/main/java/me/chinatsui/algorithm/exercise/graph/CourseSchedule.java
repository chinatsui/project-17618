package me.chinatsui.algorithm.exercise.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Solution.INSTANCE.canFinish(4, prerequisites));
    }

    enum Solution {
        INSTANCE;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            DirectedGraph graph = new DirectedGraph(numCourses);
            for (int[] entry : prerequisites) {
                graph.addEdge(entry[1], entry[0]);
            }
            DirectedGraphCycleCheck cycleCheck = new DirectedGraphCycleCheck(graph);
            return !cycleCheck.hasCycle;
        }
    }

    @SuppressWarnings("unchecked")
    static class DirectedGraph {
        int N;
        Set<Integer>[] adjacent;

        DirectedGraph(int n) {
            N = n;
            adjacent = new Set[N];
            for (int i = 0; i < N; i++) {
                adjacent[i] = new HashSet<>();
            }
        }

        void addEdge(int v, int w) {
            adjacent[v].add(w);
        }

        Set<Integer> getAdjSet(int v) {
            return adjacent[v];
        }

        int getVertexCount() {
            return N;
        }
    }

    static class DirectedGraphCycleCheck {
        DirectedGraph graph;
        boolean hasCycle;
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> trace = new Stack<>();

        DirectedGraphCycleCheck(DirectedGraph graph) {
            this.graph = graph;
            int cnt = this.graph.getVertexCount();
            for (int i = 0; i < cnt; i++) {
                if (!visited.contains(i)) {
                    dfs(i);
                    trace.clear();
                }
            }
        }

        void dfs(int v) {
            if (hasCycle) {
                return;
            }

            visited.add(v);
            trace.push(v);

            for (Integer w : graph.getAdjSet(v)) {
                if (!visited.contains(w)) {
                    dfs(w);
                } else if (trace.contains(w)) {
                    hasCycle = true;
                    return;
                }
            }

            trace.pop();
        }
    }
}

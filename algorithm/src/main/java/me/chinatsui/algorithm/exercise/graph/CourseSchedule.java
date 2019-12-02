package me.chinatsui.algorithm.exercise.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * LeetCode 207. Course Schedule
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return true;
        }

        Courses courses = new Courses(numCourses);
        for (int[] p : prerequisites) {
            courses.add(p[1], p[0]);
        }
        DependencyCheck check  = new DependencyCheck(courses);
        return !check.foundCycle;
    }

    protected static class DependencyCheck {
        private Courses courses;
        private boolean foundCycle;
        private boolean[] visited;
        private Stack<Integer> onStack;

        public DependencyCheck(Courses courses) {
            this.courses = courses;
            this.visited = new boolean[courses.size];
            onStack = new Stack<>();
            for (int i = 0; i < courses.size; i++) {
                if (foundCycle) {
                    break;
                }

                if (!visited[i]) {
                    dfs(i);
                }
            }
        }

        private void dfs(int v) {
            visited[v] = true;
            onStack.push(v);

            for (int w : courses.adj[v]) {
                if (foundCycle) {
                    return;
                }

                if (!visited[w]) {
                    dfs(w);
                } else if (onStack.contains(w)) {
                    foundCycle = true;
                    break;
                }
            }
            onStack.pop();
        }

    }

    protected static class Courses {
        private Set<Integer>[] adj;
        private int size;

        public Courses(int n) {
            this.size = n;
            this.adj = new HashSet[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new HashSet();
            }
        }

        public void add(int v, int w) {
            adj[v].add(w);
        }
    }
}

package me.chinatsui.algorithm.exercise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    private Map<Integer, List<Integer>> preMap = new HashMap<>();

    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1}, {3, 1}, {1, 3}, {3, 2}};
        System.out.println(new CourseSchedule().canFinish(4, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        init(prerequisites);

        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> seen = new HashSet<>();
            seen.add(i);
            boolean hasCycle = checkCycle(i, seen);
            if (hasCycle) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCycle(int c, HashSet<Integer> seen) {
        List<Integer> preList = getPrerequisites(c);
        if (preList == null || preList.size() < 1) {
            return false;
        }

        if (hasIntersection(preList, seen)) {
            return true;
        }

        for (int p : preList) {
            HashSet<Integer> clone = new HashSet<>(seen);
            clone.add(p);
            if (checkCycle(p, clone)) {
                return true;
            }
        }

        return false;
    }

    private void init(int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pArray = prerequisites[i];
            int key = pArray[0];
            for (int j = 1; j < pArray.length; j++) {
                preMap.putIfAbsent(key, new ArrayList<>());
                preMap.get(key).add(pArray[j]);
            }
        }
    }

    private List<Integer> getPrerequisites(int c) {
        return preMap.get(c);
    }

    private boolean hasIntersection(List<Integer> prerequisites, HashSet<Integer> seen) {
        for (int p : prerequisites) {
            if (seen.contains(p)) {
                return true;
            }
        }
        return false;
    }
}

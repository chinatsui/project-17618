package me.chinatsui.algorithm.exercise.heap;

import java.util.*;

/**
 * LeetCode 218. The Skyline Problem
 */
public class SkyLine {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length < 1) {
            return new ArrayList<>();
        }

        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        heights.sort((h1, h2) -> {
            if (h1[0] != h2[0]) {
                return h1[0] - h2[0];
            } else {
                return h1[1] - h2[1];
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((h1, h2) -> (h2 - h1));
        pq.offer(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                List<Integer> curHeight = new ArrayList<>();
                curHeight.add(h[0]);
                curHeight.add(cur);
                prev = cur;
                res.add(curHeight);
            }
        }

        return res;
    }
}

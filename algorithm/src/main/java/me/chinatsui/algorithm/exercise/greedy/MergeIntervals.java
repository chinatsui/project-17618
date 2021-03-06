    package me.chinatsui.algorithm.exercise.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode 56 - Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = res.get(res.size() - 1);
            int[] curr = intervals[i];
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                res.add(curr);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

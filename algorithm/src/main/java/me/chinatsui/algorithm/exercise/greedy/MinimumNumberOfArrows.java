package me.chinatsui.algorithm.exercise.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrows {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int arrows = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}

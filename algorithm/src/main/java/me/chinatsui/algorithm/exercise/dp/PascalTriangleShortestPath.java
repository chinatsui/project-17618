package me.chinatsui.algorithm.exercise.dp;

import java.util.ArrayList;

public class PascalTriangleShortestPath {

    public int resolve(ArrayList<ArrayList<Integer>> data) {
        if (!isValid(data)) {
            return -1;
        }

        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(data.get(0).get(0));
        for (int i = 1; i < data.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < data.get(i).size(); j++) {
                int val = data.get(i).get(j);
                if (j == 0) {
                    row.add(dp.get(0) + val);
                } else if (j == data.get(i).size() - 1) {
                    row.add(dp.get(j - 1) + val);
                } else {
                    row.add(Math.min(dp.get(j - 1), dp.get(j)) + val);
                }
            }
            dp = row;
        }

        System.out.println(dp);

        int len = Integer.MAX_VALUE;
        for (int i = 0; i < dp.size(); i++) {
            len = Math.min(len, dp.get(i));
        }

        return len;
    }

    private boolean isValid(ArrayList<ArrayList<Integer>> data) {
        if (data == null || data.size() < 1 || data.get(0).size() < 1) {
            return false;
        }

        return true;
    }
}

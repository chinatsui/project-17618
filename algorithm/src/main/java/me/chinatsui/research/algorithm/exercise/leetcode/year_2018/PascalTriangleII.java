package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangleII {

    public static void main(String[] args) {
        System.out.println(Solution3.INSTANCE.getRow(4));
    }

    public enum Solution {
        INSTANCE;

        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> pt = new ArrayList();
            pt.add(Arrays.asList(1));

            for (int i = 1; i <= rowIndex; i++) {
                int y = i;
                List<Integer> row = new ArrayList();
                row.add(1);
                for (int x = -i + 2; x <= i - 2; x += 2) {
                    Integer leftAbove = getElement(pt, x - 1, y - 1);
                    Integer rightAbove = getElement(pt, x + 1, y - 1);
                    row.add(leftAbove + rightAbove);
                }
                row.add(1);
                pt.add(row);
            }

            return pt.get(rowIndex);
        }

        private Integer getElement(List<List<Integer>> pt, int x, int y) {
            return pt.get(Math.abs(y)).get((x + y) / 2);
        }
    }

    public enum Solution2 {
        INSTANCE;

        public List<Integer> getRow(int rowIndex) {
            int[] row = new int[rowIndex + 1];
            row[0] = 1;
            for (int i = 1; i <= rowIndex; i++) {
                for (int j = i; j >= 1; j--) {
                    row[j] += row[j-1];
                }
            }
            return Arrays.stream(row).boxed().collect(Collectors.toList());
        }
    }

    public enum Solution3 {
        INSTANCE;

        public List<Integer> getRow(int rowIndex) {
            long nCk = 1;
            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i <= rowIndex; i++) {
                result.add((int) nCk);
                nCk = nCk * (rowIndex - i) / (i + 1);
            }
            return result;
        }
    }


}

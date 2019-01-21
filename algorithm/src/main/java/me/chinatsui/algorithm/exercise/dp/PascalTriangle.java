package me.chinatsui.algorithm.exercise.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {        
        System.out.println(Solution.INSTANCE.generate(5));
    }

    public enum Solution {
        INSTANCE;

        public List<List<Integer>> generate(int numRows) {
            if (numRows < 1) {
                return new ArrayList<>();
            }
    
            List<List<Integer>> triangle = new ArrayList<>();
            List<Integer> firstRow = Arrays.asList(1);
            triangle.add(firstRow);
    
            for (int i = 1; i < numRows; i++) {
                int y = i;
                List<Integer> row = new ArrayList<>();
                for (int x = -i; Math.abs(x) <= i; x += 2) {
                    int left = getNumber(triangle, x - 1, y - 1);
                    int right = getNumber(triangle, x + 1, y - 1);
                    row.add(left + right);
                }
                triangle.add(row);
            }
            return triangle;
        }
    
        private int getNumber(List<List<Integer>> triangle, int x, int y) {
            try {
                return triangle.get(y).get((x + y) / 2);
            } catch (IndexOutOfBoundsException e) {
                return 0;
            }
        }
    }
}

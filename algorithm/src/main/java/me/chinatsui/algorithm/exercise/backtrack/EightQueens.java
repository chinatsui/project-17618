package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens {

    private final int QUEEN_SIZE = 8;

    public List<int[]> resolve() {
        List<int[]> res = new ArrayList<>();
        int[] positions = new int[8];
        place(positions, 0, res);
        return res;
    }

    private void place(int[] positions, int row, List<int[]> res) {
        if (row == QUEEN_SIZE) {
            res.add(Arrays.copyOf(positions, QUEEN_SIZE));
        } else {
            for (int col = 0; col < QUEEN_SIZE; col++) {
                if (check(positions, row, col)) {
                    positions[row] = col;
                    place(positions, row + 1, res);
                }
            }
        }
    }

    private boolean check(int[] positions, int row, int col) {
        int leftUp = col - 1, rightUp = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (positions[i] == col) {
                return false;
            }

            if (positions[i] == leftUp) {
                return false;
            }

            if (positions[i] == rightUp) {
                return false;
            }

            leftUp--;
            rightUp++;
        }

        return true;
    }
}

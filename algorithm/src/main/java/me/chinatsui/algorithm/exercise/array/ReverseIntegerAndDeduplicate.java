package me.chinatsui.algorithm.exercise.array;

import java.util.LinkedHashSet;

public class ReverseIntegerAndDeduplicate {

    public int resolve(int num) {
        if (num <= 0) {
            return 0;
        }

        LinkedHashSet<Integer> ts = new LinkedHashSet<>();
        while (num > 0) {
            ts.add(num % 10);
            num = num / 10;
        }

        int res = 0;
        for (int i : ts) {
            res = res * 10 + i;
        }

        return res;
    }
}

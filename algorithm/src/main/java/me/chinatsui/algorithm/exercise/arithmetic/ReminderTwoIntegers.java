package me.chinatsui.algorithm.exercise.arithmetic;

public class ReminderTwoIntegers {

    public int getReminder(int a, int b) {
        if (a == b || b == 1 || b == -1 || a == 0) {
            return 0;
        }

        if (b == Integer.MIN_VALUE) {
            return a;
        }

        boolean positive = a > 0;

        if (b < 0) {
            b = -b;
        }

        if (a == Integer.MIN_VALUE) {
            a += b;
        }

        if (a < 0) {
            a = -a;
        }

        int boost = 0;
        while (b << boost + 1 > 0 && b << boost + 1 <= a) {
            boost++;
        }

        while (a >= b) {
            if (a >= b << boost) {
                a -= b << boost;
            }
            boost--;
        }

        return positive ? a : -a;
    }
}

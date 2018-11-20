package me.chinatsui.algorithm.exercise.arithmetic;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(Solution2.INSTANCE.gct(36, 30));
    }

    public enum Solution {
        INSTANCE;

        public int gct(int x, int y) {
            if (x == 0 || y == 0) {
                return Math.max(x, y);
            }
            while (y > 0) {
                int mod = x % y;
                x = y;
                y = mod;
            }
            return x;
        }
    }

    public enum Solution2 {
        INSTANCE;

        public int gct(int x, int y) {
            if (x == 0 || y == 0) {
                return Math.max(x, y);
            } else {
                return gct(y, x % y);
            }
        }
    }
}

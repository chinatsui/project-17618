package me.chinatsui.exercise.leetcode.mar;

public class MySqrt {

    public static void main(String[] args) {
        int result = new MySqrt().sqrt(1);
        System.out.println(result);
    }

    public int sqrt(int num) {
        int l = 1;
        int h = num;

        while (true) {
            int m = l + (h - l) / 2;
            if (m > num / m) {
                h = m - 1;
            } else {
                if (m + 1 > num / (m + 1)) {
                    return m;
                } else {
                    l = m + 1;
                }
            }
        }
    }

}

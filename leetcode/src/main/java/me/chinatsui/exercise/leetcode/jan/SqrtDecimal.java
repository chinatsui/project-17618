package me.chinatsui.exercise.leetcode.jan;


public class SqrtDecimal {

    public static void main(String[] args) {
        System.out.println(new SqrtDecimal().mySqrt(1000000));
    }

    public long mySqrt(int x) {
        long lo = 1;
        long hi = x;

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid > x) {
                hi = mid - 1;
            } else if (mid * mid < x) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo * lo > x ? lo - 1 : lo;
    }

}

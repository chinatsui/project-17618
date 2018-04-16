package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.List;

public enum PrimeFactorization {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.getFactors(1024));
    }

    private List<Integer> getFactors(int num) {
        int factor = 2;
        List<Integer> factors = new ArrayList<>();

        while (num != 1) {
            if (num % factor == 0) {
                factors.add(factor);
                num /= factor;
            } else {
                factor++;
            }
        }

        return factors;
    }

}

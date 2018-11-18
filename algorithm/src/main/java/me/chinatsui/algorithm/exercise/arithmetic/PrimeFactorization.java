package me.chinatsui.algorithm.exercise.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.getFactors(1024));
    }

    public enum Solution {
        INSTANCE;

        public List<Integer> getFactors(int num) {
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
}

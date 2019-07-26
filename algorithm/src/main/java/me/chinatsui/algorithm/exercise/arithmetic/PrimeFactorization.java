package me.chinatsui.algorithm.exercise.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public int[] getPrimeFactors(int num) {
        int prime = 2;
        int cur = num;
        List<Integer> factors = new ArrayList<>();

        while (cur > 1 && prime < num) {
            if (cur % prime == 0) {
                factors.add(prime);
                cur /= prime;
            } else {
                prime++;
            }
        }

        return factors.stream().mapToInt(i -> i).toArray();
    }
}

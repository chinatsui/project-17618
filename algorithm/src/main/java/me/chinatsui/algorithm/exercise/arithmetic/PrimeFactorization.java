package me.chinatsui.algorithm.exercise.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public int[] getPrimeFactors(int num) {
        if (num < 1) {
            throw new IllegalArgumentException();
        }

        if (num == 1) {
            return new int[0];
        }

        List<Integer> primes = new ArrayList<>();

        // First, add all of the prime number 2
        while (num % 2 == 0) {
            primes.add(2);
            num /= 2;
        }

        // Second, check all odd number starting from 3 till square root of num
        for (int i = 3; i * i <= num; i += 2) {
            // While i divides n, add i and divide n
            while (num % i == 0) {
                primes.add(i);
                num /= i;
            }
        }

        // Third, check if num is larger than 2 after all divisions
        if (num > 2) {
            primes.add(num);
        }

        return primes.stream().mapToInt(i -> i).toArray();
    }
}

package me.chinatsui.algorithm.exercise.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public List<Integer> getPrimeFactors(int num) {
        List<Integer> primes = new ArrayList<>();

        // Print the number of 2s that divide n
        while (num % 2 == 0) {
            primes.add(2);
            num /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i * i <= num; i += 2) {
            // While i divides n, print i and divide n
            while (num % i == 0) {
                primes.add(i);
                num /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (num > 2) {
            primes.add(num);
        }

        return primes;
    }
}

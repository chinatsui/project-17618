package me.chinatsui.algorithm.exercise.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class PrimeFactorizationTest {

    PrimeFactorization pf = new PrimeFactorization();

    @Test
    public void test_getPrimeFactors_when_given_negative_number_returns_empty_factors() {
        Assert.assertArrayEquals(new int[0], pf.getPrimeFactors(-1));
        Assert.assertArrayEquals(new int[0], pf.getPrimeFactors(-10));
        Assert.assertArrayEquals(new int[0], pf.getPrimeFactors(-255));
    }

    @Test
    public void test_getPrimeFactors_when_given_zero_returns_empty_factors() {
        Assert.assertArrayEquals(new int[0], pf.getPrimeFactors(0));
    }

    @Test
    public void test_getPrimeFactors_when_given_prime_number_returns_empty_factors() {
        Assert.assertArrayEquals(new int[0], pf.getPrimeFactors(13));
    }

    @Test
    public void test_getPrimeFactors_when_given_composite_number_returns_expected_factors() {
        int[] expected = {2, 2, 3, 3, 5};
        Assert.assertArrayEquals(expected, pf.getPrimeFactors(180));
    }
}

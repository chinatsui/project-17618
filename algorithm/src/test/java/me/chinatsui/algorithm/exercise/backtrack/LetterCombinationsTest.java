package me.chinatsui.algorithm.exercise.backtrack;

import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationsTest {

    private LetterCombinations letterCombinations = new LetterCombinations();

    @Test
    public void test() {
        Assert.assertEquals(9, letterCombinations.letterCombinations("23").size());
    }
}

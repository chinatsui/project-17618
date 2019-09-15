package me.chinatsui.algorithm.exercise.string;

import org.junit.Assert;
import org.junit.Test;

public class BMSearchTest {

    private BMSearch BMSearch = new BMSearch();

    @Test
    public void test_search_when_text_contains_pattern() {
        char[] text = "abcdefgabdefabs".toCharArray();
        char[] pattern = "efgab".toCharArray();
        Assert.assertEquals(4, BMSearch.search(text, pattern));
    }

    @Test
    public void test_search_when_text_not_contains_pattern() {
        char[] text = "abcdefgabdefabs".toCharArray();
        char[] pattern = "efgax".toCharArray();
        Assert.assertEquals(-1, BMSearch.search(text, pattern));
    }
}

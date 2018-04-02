package me.chinatsui.research.other;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    @Test
    public void test_split_white_space() {
        String input = "a  b c d e f g";

        String[] split = input.split(" +");
        System.out.println(Arrays.toString(split));
        Assert.assertEquals(7, split.length);

        String[] split2 = input.split("\\*?");
        System.out.println(Arrays.toString(split2));
        Assert.assertEquals(14, split2.length);
    }

    @Test
    public void test_bound() {
        Pattern no_bound = Pattern.compile("here");

        Matcher m1 = no_bound.matcher("adhered");
        Assert.assertTrue(m1.find());
        Assert.assertEquals("here", m1.group());

        Matcher m2 = no_bound.matcher("I am here.");
        Assert.assertTrue(m2.find());
        Assert.assertEquals("here", m2.group());

        Pattern has_bound = Pattern.compile("here\\b");

        Matcher m3 = has_bound.matcher("adhered");
        Assert.assertFalse(m3.find());

        Matcher m4 = has_bound.matcher("I am here.");
        Assert.assertTrue(m4.find());
        Assert.assertEquals("here", m4.group());
    }

    @Test
    public void test_greedy_and_reluctant_match() {
        String input = "abcabc def abc";

        Pattern greedy = Pattern.compile("a.*c");
        Matcher m1 = greedy.matcher(input);
        Assert.assertTrue(m1.find());
        Assert.assertEquals(input, m1.group());

        Pattern reluctant = Pattern.compile("a.*?c");
        Matcher m2 = reluctant.matcher(input);
        Assert.assertTrue(m2.find());
        Assert.assertEquals("abc", m2.group());
    }

    @Test
    public void test_anti_reference() {
        String input = "<text>abc1235</text>";

        // \1 means referencing the first bracket regex, \2 means the second and so on.
        Pattern p = Pattern.compile("<(\\w*)></\\1>");
        Matcher m = p.matcher(input);

        Assert.assertTrue(m.find());
        Assert.assertEquals(input, m.group());
    }

}

package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chinatsui on 14/01/2018.
 */
public class PhoneNumberLetterCombination {

    private static Map<String, List<String>> phoneNumberLetters = new HashMap();

    static {
        List<String> one_Letters = new ArrayList<>();
        one_Letters.add("");
        phoneNumberLetters.put("1", one_Letters);

        List<String> two_Letters = new ArrayList<>();
        two_Letters.add("a");
        two_Letters.add("b");
        two_Letters.add("c");
        phoneNumberLetters.put("2", two_Letters);


        List<String> three_Letters = new ArrayList<>();
        three_Letters.add("d");
        three_Letters.add("e");
        three_Letters.add("f");
        phoneNumberLetters.put("3", three_Letters);

        List<String> four_Letters = new ArrayList<>();
        four_Letters.add("g");
        four_Letters.add("h");
        four_Letters.add("i");
        phoneNumberLetters.put("4", four_Letters);


        List<String> five_Letters = new ArrayList<>();
        five_Letters.add("j");
        five_Letters.add("k");
        five_Letters.add("l");
        phoneNumberLetters.put("5", five_Letters);


        List<String> six_Letters = new ArrayList<>();
        six_Letters.add("m");
        six_Letters.add("n");
        six_Letters.add("o");
        phoneNumberLetters.put("6", six_Letters);


        List<String> seven_Letters = new ArrayList<>();
        seven_Letters.add("p");
        seven_Letters.add("q");
        seven_Letters.add("r");
        seven_Letters.add("s");
        phoneNumberLetters.put("7", seven_Letters);


        List<String> eight_Letters = new ArrayList<>();
        eight_Letters.add("t");
        eight_Letters.add("u");
        eight_Letters.add("v");
        phoneNumberLetters.put("8", eight_Letters);


        List<String> nine_Letters = new ArrayList<>();
        nine_Letters.add("w");
        nine_Letters.add("x");
        nine_Letters.add("y");
        nine_Letters.add("z");
        phoneNumberLetters.put("9", nine_Letters);
    }

    public static void main(String[] args) {
        List<String> results = new PhoneNumberLetterCombination().letterCombinations2("2345623");
        for (String res : results) {
            System.out.println(res);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return new ArrayList<>();
        }

        List<String> results = new ArrayList<>();
        String buffer = "";
        traverse(digits, buffer, results);
        return results;
    }

    private void traverse(String digits, String buffer, List<String> results) {
        if (digits.length() == 0) {
            results.add(buffer);
        } else {
            String digit = String.valueOf(digits.charAt(0));
            List<String> letters = phoneNumberLetters.get(digit);

            String nextDigits = digits.substring(1);
            for (String letter : letters) {
                traverse(nextDigits, buffer + letter, results);
            }
        }
    }

    public List<String> letterCombinations2(String digits) {
        if (digits == null) {
            return new ArrayList<>();
        }

        List<String> results = new ArrayList<>();
        results.add("");

        while (digits.length() > 0) {
            String digit = String.valueOf(digits.charAt(0));
            List<String> letters = phoneNumberLetters.get(digit);

            List<String> nextResults = new ArrayList<>();
            for (String res : results) {
                for (String letter : letters) {
                    nextResults.add(res + letter);
                }
            }
            results = nextResults;
            digits = digits.substring(1);
        }
        return results;
    }

}

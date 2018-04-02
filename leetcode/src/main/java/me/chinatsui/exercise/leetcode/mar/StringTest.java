package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        String m = "a" + 'c';
        String n = new String("" + 'a' + 'c');
        System.out.println(m == n);
        System.out.println(m == "ac");
        System.out.println(n == "ac");

        List<String> results = new ArrayList();
        results.add("a");
        results.add("b");
        System.out.println(results);

        List<String> tmp = new ArrayList<>();
        tmp.add("d");
        tmp.add("e");

        results.clear();
        results.addAll(tmp);

        System.out.println(results);

        char[][] words = new char[1][1];
        words[0] = new char[]{};
    }

}

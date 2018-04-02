package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            String normalized = normalize(s);
            groups.putIfAbsent(normalized, new ArrayList<>());
            groups.get(normalized).add(s);
        }

        return groups.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
    }

    private String normalize(String anagram) {
        if (anagram == null) {
            return null;
        }

        char[] ch = anagram.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

}

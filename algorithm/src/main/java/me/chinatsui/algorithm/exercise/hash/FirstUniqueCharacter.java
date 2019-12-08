package me.chinatsui.algorithm.exercise.hash;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }

        Set<Character> set = new HashSet<>();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                map.remove(ch);
            } else {
                set.add(ch);
                map.put(ch, i);
            }
        }

        return map.size() > 0 ? map.entrySet().iterator().next().getValue() : -1;
    }
}

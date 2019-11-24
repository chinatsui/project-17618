package me.chinatsui.algorithm.exercise.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 127 - Word　Ladder
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * <p>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * Input:  beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * <p>
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // validate(beginWord, endWord, wordList);
        Set<String> reached = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);

        int steps = 1;
        reached.add(beginWord);

        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String cur : reached) {
                for (int i = 0; i < cur.length(); i++) {
                    char[] chars = cur.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String next = new String(chars);
                        if (words.contains(next)) {
                            toAdd.add(next);
                            words.remove(next);
                        }
                    }
                }
            }
            steps++;
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }

        return steps;
    }
}

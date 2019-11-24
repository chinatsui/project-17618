package me.chinatsui.algorithm.exercise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * LeetCode 126 - Word Ladder II
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * <p>
 * Note:
 * 1. Return an empty list if there is no such transformation sequence.
 * 2. All words have the same length.
 * 3. All words contain only lowercase alphabetic characters.
 * 4. You may assume no duplicates in the word list.
 * 5. You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadderII {

    private int steps = 1;
    private HashMap<String, Set<String>> adj = new HashMap<>();
    private HashMap<String, Integer> distance = new HashMap<>();
    private List<List<String>> paths = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // validate(beginWord, endWord, wordList);
        Set<String> wordSet = new HashSet<>(wordList);
        bfs(beginWord, endWord, wordSet);

        if (steps > 0) {
            dfs(beginWord, endWord, new ArrayList<>());
        }

        return paths;
    }

    private void bfs(String src, String dst, Set<String> wordSet) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(src);
        distance.put(src, 1);
        while (!distance.containsKey(dst) && !queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    char[] chars = cur.toCharArray();
                    char oldChar = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (oldChar == ch) {
                            continue;
                        }

                        chars[i] = ch;
                        String next = new String(chars);

                        if (!wordSet.contains(next)) {
                            continue;
                        }

                        adj.putIfAbsent(cur, new HashSet<>());
                        adj.get(cur).add(next);

                        if (!distance.containsKey(next)) {
                            queue.add(next);
                            distance.put(next, steps + 1);
                        }
                    }
                }
            }
            steps++;
        }

        if (!distance.containsKey(dst)) {
            steps = -1;
        }
    }

    private void dfs(String curWord, String endWord, List<String> curPath) {
        curPath.add(curWord);
        if (Objects.equals(curWord, endWord)) {
            paths.add(new ArrayList<>(curPath));
        } else {
            if (!adj.containsKey(curWord)) {
                return;
            }

            int curDist = distance.get(curWord);
            for (String nextWord : adj.get(curWord)) {
                int nextDist = distance.get(nextWord);
                if (curDist + 1 != nextDist) {
                    continue;
                }

                dfs(nextWord, endWord, curPath);
                curPath.remove(curPath.size() - 1);
            }
        }
    }
}

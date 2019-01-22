package me.chinatsui.algorithm.exercise.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class WordLadder {

    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.ladderLength(
                "hit",
                "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public enum Solution {
        INSTANCE;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<Pair> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Set<String> dict = new HashSet<>(wordList);

            q.offer(new Pair(beginWord, 1));
            visited.add(beginWord);

            while (!q.isEmpty()) {
                Pair pair = q.poll();
                String word = pair.word;
                Integer dst = pair.dst;

                if (word.equals(endWord)) {
                    return dst;
                }

                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String tmp = word.substring(0, i) + ch + word.substring(i + 1);
                        if (!visited.contains(tmp) && dict.contains(tmp)) {
                            q.offer(new Pair(tmp, dst + 1));
                            visited.add(tmp);
                        }
                    }
                }
            }
            return 0;
        }
    }

    private static class Pair {
        private String word;
        private Integer dst;

        public Pair(String word, Integer dst) {
            this.word = word;
            this.dst = dst;
        }
    }
}

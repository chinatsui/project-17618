package me.chinatsui.algorithm.exercise.matrix;

/**
 * LeetCode 79. Word Search
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * <p>
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }

        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        visited[i][j] = true;
        boolean found = dfs(board, word, i + 1, j, k + 1, visited)
                || dfs(board, word, i - 1, j, k + 1, visited)
                || dfs(board, word, i, j + 1, k + 1, visited)
                || dfs(board, word, i, j - 1, k + 1, visited);
        visited[i][j] = false;
        return found;
    }
}

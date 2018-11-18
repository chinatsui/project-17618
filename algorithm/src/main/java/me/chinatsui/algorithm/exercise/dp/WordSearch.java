package me.chinatsui.algorithm.exercise.dp;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean isExist = Solution.INSTANCE.exist(board, word);
        System.out.println(isExist);
    }

    public enum Solution {
        INSTANCE;

        public boolean exist(char[][] board, String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            if (board == null || board[0] == null || board[0].length < 1) {
                return false;
            }

            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
            if (idx == word.length()) {
                return true;
            }

            if (i < 0 || i == board.length || j < 0 || j == board[0].length || visited[i][j]) {
                return false;
            }

            if (board[i][j] != word.charAt(idx)) {
                return false;
            }

            visited[i][j] = true;
            boolean exists =
                    dfs(board, i, j - 1, word, idx + 1, visited) ||
                    dfs(board, i, j + 1, word, idx + 1, visited) ||
                    dfs(board, i - 1, j, word, idx + 1, visited) ||
                    dfs(board, i + 1, j, word, idx + 1, visited);
            visited[i][j] = false;
            return exists;
        }
    }
}

/**
 * Time Complexity: O(N * 3 ^ L) : N is the number of cells.
 * Space Complexity: O(m * n)  for a mxn board.
 **/
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, word, i, j, new boolean[board.length][board[0].length]);
                if (result) {
                    return result;
                }
            }
        }

        return false;
    }

    boolean result = false;

    void backtrack(char[][] board, String word, int i, int j, boolean[][] visited) {
        if (word.length() == 0) {
            result = true;
            return;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || word.charAt(0) != board[i][j]) {
            return;
        }

        visited[i][j] = true;
        backtrack(board, word.substring(1), i, j + 1, visited);
        backtrack(board, word.substring(1), i, j - 1, visited);
        backtrack(board, word.substring(1), i + 1, j, visited);
        backtrack(board, word.substring(1), i - 1, j, visited);
        visited[i][j] = false;

    }

}
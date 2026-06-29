class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] passed = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(0, word, row, col, board, passed)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(
        int position, String word, int row, int col, char[][] board, boolean[][] passed) {
        if (row < 0 || row >= board.length) {
            return false;
        }
        if (col < 0 || col >= board[0].length) {
            return false;
        }

        if (passed[row][col]) {
            return false;
        }

        if (position == word.length() - 1) {
            return word.charAt(position) == board[row][col];
        }

        if (board[row][col] == word.charAt(position)) {
            passed[row][col] = true;
            if (backtrack(position + 1, word, row + 1, col, board, passed)) {
                return true;
            }
            if (backtrack(position + 1, word, row - 1, col, board, passed)) {
                return true;
            }
            if (backtrack(position + 1, word, row, col + 1, board, passed)) {
                return true;
            }
            if (backtrack(position + 1, word, row, col - 1, board, passed)) {
                return true;
            }
            passed[row][col] = false;
        }
        return false;
    }
}

// use backtracking
// if board contains letter check if next tile contains next letter
//"A","B","C","E"
//"S","F","C","S"
//"A","D","E","E"

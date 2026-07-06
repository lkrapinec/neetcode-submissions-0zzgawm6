class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                markUncaptured(row, 0, board);
            }
            if (board[row][board[0].length - 1] == 'O') {
                markUncaptured(row, board[0].length - 1, board);
            }
        }

        for (int col = 0; col < board[0].length; col++) {
             if (board[0][col] == 'O') {
                markUncaptured(0, col, board);
            }
            if (board[board.length - 1][col] == 'O') {
                markUncaptured(board.length - 1, col, board);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }else if(board[row][col] == 'N'){
                    board[row][col] = 'O';
                }
            }

        }
    }

    private void markUncaptured(int startRow, int startCol, char[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {startRow, startCol});
        board[startRow][startCol] = 'N';

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int row = position[0] + direction[0];
                int col = position[1] + direction[1];

                if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                    continue;
                }
                if (board[row][col] != 'O') {
                    continue;
                }

                board[row][col] = 'N';
                queue.offer(new int[] {row, col});
            }
        }
    }
}
// find all regions that are on the border and leave then
// mark rest of regions as surrounded
// if region is not surrounded replace sybol with N
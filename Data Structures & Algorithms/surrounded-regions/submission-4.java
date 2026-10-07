class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}

    };
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int row = 0; row < rows; row++){
            if(board[row][0] == 'O'){
                markUncapptured(row, 0, board);
            }
             if(board[row][cols - 1] == 'O'){
                markUncapptured(row, cols - 1, board);
            }
        }

        for(int col = 1; col < cols; col++){
            if(board[0][col] == 'O'){
                markUncapptured(0, col, board);
            }
            if(board[rows - 1][col] == 'O'){
                markUncapptured(rows - 1, col, board);
            }
        }

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }else if(board[row][col] == 'U'){
                    board[row][col] = 'O';
                }
            }
        }


    }

    private void markUncapptured(int row, int col, char[][] board){
        board[row][col] = 'U';

        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow >= 0 && nextRow < board.length &&
                nextCol >= 0 && nextCol < board[0].length &&
                board[nextRow][nextCol] == 'O'){
                    markUncapptured(nextRow, nextCol, board);
                }
        }
    }
}

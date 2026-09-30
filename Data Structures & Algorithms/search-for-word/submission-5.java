class Solution {
    private static final char EMPTY = '#';
    private static final int[][] DIRECTIONS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                 if(backtrack(i, j, board, 0, word)){
                    return true;
                 }
            }
        }

        return false;
    }

    private boolean backtrack(int row, int col, char[][] board, int position, String word){
        char curr = board[row][col];
        if(curr != word.charAt(position)){
            return false;
        }

        if(position + 1 == word.length()){
            return true;
        }

        board[row][col] = EMPTY;
        boolean result = false;

        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length){
                if(backtrack(nextRow, nextCol, board, position + 1, word)){
                    result = true;
                    break;
                }
            }
        }

        board[row][col] = curr;
        return result;
    }
}

//for each position go with dfs until characters mismatch
//if they match return true
//use backtracking
//mark passed fields to avoid iteration of the same field
//in dfs move in 4 directions if they are in bound and not already visited
//to mark visited fields replace letter with special character

//time compexity: visit each cell once -> O(n*m) and for each cell go in depth up to word length -> O(n*m*length)
//space complexity: recursion up to length chars O(length)

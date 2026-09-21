class Solution {
    private static final int[][] DIRECTIONS= {
        {1,0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int[][] moves = new int[matrix.length][matrix[0].length];
        
        int result = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.max(result, recursion(i,j, moves, matrix));
            }
        }
         return result;
    }

    private int recursion(int row, int col, int[][] moves, int[][] matrix){
        if(moves[row][col] != 0){
            return moves[row][col];
        }

        int curr = matrix[row][col];
        int result = 1;

        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow >= 0 && nextRow < moves.length && nextCol >= 0 && nextCol < moves[0].length && matrix[nextRow][nextCol] > curr){
                result = Math.max(result, recursion(nextRow, nextCol, moves, matrix) + 1);
            }
        }
        moves[row][col] = result;

        return result;
    }
}
class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1'){
                    mark(row, col, grid);
                    result++;
                }
            }
        }

        return result;
    }

    private void mark(int row, int col, char[][] grid){
        grid[row][col] = '0';

        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(nextRow >= 0 && nextRow < grid.length &&
                nextCol >= 0 && nextCol < grid[0].length &&
                grid[nextRow][nextCol] == '1'){
                    mark(nextRow, nextCol, grid);
                }
        }
    }
}

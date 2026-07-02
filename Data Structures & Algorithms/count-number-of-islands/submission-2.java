class Solution {
    private static final int[][]  DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    numberOfIslands++;
                    markIsland(i, j, grid);
                }
            }
        }

        return numberOfIslands;
    }

    private void markIsland(int row, int col, char[][] grid){
        if(!(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length)){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        for(int[] direction : DIRECTIONS){
            markIsland(row + direction[0], col + direction[1], grid);
        }
    }
}
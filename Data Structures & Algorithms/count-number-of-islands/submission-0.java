class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    numberOfIslands++;
                    markIsland(i, j, grid, rows, cols);
                }
            }
        }

        return numberOfIslands;
    }

    private void markIsland(int row, int col, char[][] grid, int rows, int cols){
        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        if(row + 1 < rows){
            markIsland(row + 1, col, grid, rows, cols);
        }
        if(row - 1 >= 0){
            markIsland(row - 1, col, grid, rows, cols);
        }

        if(col + 1 < cols){
            markIsland(row, col + 1, grid, rows, cols);
        }
        if(col - 1 >= 0){
            markIsland(row, col - 1, grid, rows, cols);
        }
    }
}

//recursion, associate each island as unique vertex
//mark visited land, if curr = 1 and prev = unique land, then curr = unique land, maybe just count number of different islands
//visit next field, and stop when there is water
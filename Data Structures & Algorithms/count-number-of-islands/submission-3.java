class Solution {
    private static final char PASSED = 'X';
    private static final int[][] DIRECTIONS = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    public int numIslands(char[][] grid) {
        int result = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    markIsland(row, col, grid);
                    result++;
                }
            }
        }

        return result;
    }

    private void markIsland(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }

        if(grid[row][col] != '1'){
            return;
        }
        grid[row][col] = PASSED;

        for(int[] direction : DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            markIsland(nextRow, nextCol, grid);
        }
    }
}

//go through each row and col
//if curr cell is 1, then move in 4 directions to find other cells that contain 1
//replace 1 with char that mark cell passed
//for first recursion call increase result
//time complexity O(n+m)
//space complexity O(1)
class Solution {
    private static final int[][] POSITIONS = {
        {1, 0},
        {-1,0},
        {0, 1},
        {0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    int area = calculateArea(row, col, grid);
                    maxArea = Math.max(maxArea, area);
                }
                
            }
        }
        return maxArea;
    }

    private int calculateArea(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }

        if(grid[row][col] == 0){
            return 0;
        }

        int area = 1;
        grid[row][col] = 0;
        for(int[] position : POSITIONS){
            area += calculateArea(row + position[0], col + position[1], grid);
        }

        return area;
    }
}

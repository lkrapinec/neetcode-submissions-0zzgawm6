class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    int area = findArea(row, col, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int findArea(int row, int col, int[][] grid){
        Queue<int[]> queue = new ArrayDeque<>();

        grid[row][col] = 0;
        queue.offer(new int[]{row, col});
        

        int area = 0;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();

            
            area++;

            for(int[] direction : DIRECTIONS){
                int nextRow = cell[0] + direction[0];
                int nextCol = cell[1] + direction[1];

                if(nextRow >= 0 && nextRow < grid.length &&
                    nextCol >= 0 && nextCol < grid[0].length
                    && grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 0;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
            }

        }

        return area;

    }
}

//go through each cell (row and col)
//if you find a 1, then look for next 4 cells for 1
//for each cell increase area
//when area of the island is calculated, then compare it with max area
//replace all found 1s with 0s


//[1,1,0,0,0]
//[1,1,0,0,0]
//[0,0,0,1,1]
//[0,0,0,1,1]
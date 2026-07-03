class Solution {
    private static final int[][] POSITIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int area = calculateArea(row, col, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int calculateArea(int row, int col, int[][] grid){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row,col});
        grid[row][col] = 0;
        
        int  area = 0;
        while(!queue.isEmpty()){
            int[] rowAndColumn = queue.remove();
            area++;

            for(int[] position : POSITIONS){
                int currRow = rowAndColumn[0] + position[0];
                if(currRow < 0 || currRow >= grid.length){
                    continue;
                }

                int currCol = rowAndColumn[1] + position[1];
                if(currCol < 0 || currCol >= grid[0].length){
                    continue;
                }

                if(grid[currRow][currCol] == 1){
                    queue.add(new int[]{currRow, currCol});
                    grid[currRow][currCol] = 0;
                }
                
            }
        }
        return area;
    }
}

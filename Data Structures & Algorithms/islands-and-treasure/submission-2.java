class Solution {
    private static final int[][] DISTANCES = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    private static final int TRAVERSE = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] position = queue.poll();

            for(int[] distance : DISTANCES){
                int row = position[0] + distance[0];
                int col = position[1] + distance[1];

                if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                    continue;
                }

                if(grid[row][col] != TRAVERSE){
                    continue;
                }

                grid[row][col] = grid[position[0]][position[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }
    }
}

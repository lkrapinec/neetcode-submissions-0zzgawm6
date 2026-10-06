class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0){
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int depth = -1;
        while(!queue.isEmpty()){
            int size = queue.size();   
            depth++;
            
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();

                for(int[] direction : DIRECTIONS){
                    int nextRow = cell[0] + direction[0];
                    int nextCol = cell[1] + direction[1];

                    if(nextRow >= 0 && nextRow < grid.length &&
                        nextCol >= 0 && nextCol < grid[0].length
                        && grid[nextRow][nextCol] == Integer.MAX_VALUE){
                            grid[nextRow][nextCol] = depth + 1;
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                }
            }
        }

    }
}

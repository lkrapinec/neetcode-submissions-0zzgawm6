class Solution {
    private static final int[][] DIRECTIONS = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int fresh = 0;

        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }
        int minute = -1;
        
        while(!queue.isEmpty()){
            minute++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] position = queue.poll();

                for(int[] direction : DIRECTIONS){
                    int row = position[0] + direction[0];
                    int col = position[1] + direction[1];
                    if(row < 0 || row >= rowLength || col < 0 || col >= colLength){
                        continue;
                    }

                    if(grid[row][col] == 1){
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        fresh--;
                    }

                }
            } 
        }

        if(fresh > 0){
            return -1;
        }

        return minute;
    }
}

//find all the rotten fruits, and expand minutes
//if there is still non roten fruit, return -1
class Solution {
    private static final int[][] POSITIONS = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
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
                int[] currPosition = queue.poll();

                for(int[] position : POSITIONS){
                    int nextRow = currPosition[0] + position[0];
                    int nextCol = currPosition[1] + position[1];
                    if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length){
                        continue;
                    }

                    if(grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 2;
                        queue.offer(new int[]{nextRow, nextCol});
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
class Solution {
    private static final int[][] POSITIONS = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public int swimInWater(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[rowLength][colLength];

        minHeap.offer(new int[]{0,0, grid[0][0]});
        visited[0][0] = true;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            if(curr[0] == rowLength - 1 && curr[1] == colLength - 1){
                return curr[2];
            }

            

            for(int[] position : POSITIONS){
                int x = position[0] + curr[0];
                if(x < 0 || x >= rowLength){
                    continue;
                }

                int y = position[1] + curr[1];
                if(y < 0 || y >= colLength){
                    continue;
                }

                if(visited[x][y]){
                    continue;
                }

                minHeap.offer(new int[]{x,y,Math.max(curr[2], grid[x][y])});
                visited[x][y] = true;
            }
        }
        return -1;
    }
}

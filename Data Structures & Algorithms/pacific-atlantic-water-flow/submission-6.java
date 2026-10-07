class Solution {
    private static final int[][] DIRECTIONS = {
        {1,0},
        {-1,0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] toAtlantic = new boolean[rows][cols];
        boolean[][] toPacific = new boolean[rows][cols];

        Queue<int[]> queueAtlantic = new ArrayDeque<>();
        Queue<int[]> queuePacific = new ArrayDeque<>();
        for(int row = 0; row < rows; row++){
            queueAtlantic.offer(new int[]{row, 0});
            toAtlantic[row][0] = true;
            queuePacific.offer(new int[]{row,cols - 1});
            toPacific[row][cols - 1] = true;
        }

        for(int col = 0; col < cols; col++){
            queueAtlantic.offer(new int[]{0, col});
            toAtlantic[0][col] = true;
            queuePacific.offer(new int[]{rows - 1, col});
            toPacific[rows - 1][col] = true;
        }

        calculateToOcean(queueAtlantic, toAtlantic, heights);
        calculateToOcean(queuePacific, toPacific, heights);

        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(toAtlantic[row][col] == true && toPacific[row][col] == true){
                    result.add(List.of(row,col));
                }
            }
        }

        return result;
    }

    private void calculateToOcean(Queue<int[]> queue, boolean[][] toOcean, int[][] heights){
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] direction : DIRECTIONS){
                int nextRow = cell[0] + direction[0];
                int nextCol = cell[1] + direction[1];

                if(nextRow >= 0 && nextRow < heights.length &&
                    nextCol >= 0 && nextCol < heights[0].length &&
                    toOcean[nextRow][nextCol] == false
                    && heights[cell[0]][cell[1]] <= heights[nextRow][nextCol]){
                        toOcean[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }

            }
        }
    }
}

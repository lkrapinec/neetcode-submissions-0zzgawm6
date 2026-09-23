class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] indegree = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                        && matrix[nextRow][nextCol] > matrix[row][col]  ) {
                        indegree[nextRow][nextCol]++;
                    }
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(indegree[row][col] == 0){
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();

                for(int[] direction : DIRECTIONS){
                    int nextRow = cell[0] + direction[0];
                    int nextCol = cell[1] + direction[1];

                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                        && matrix[nextRow][nextCol] > matrix[cell[0]][cell[1]]) {
                        indegree[nextRow][nextCol]--;

                        if(indegree[nextRow][nextCol] == 0){
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
            result++;
        }

        return result;

    }
}

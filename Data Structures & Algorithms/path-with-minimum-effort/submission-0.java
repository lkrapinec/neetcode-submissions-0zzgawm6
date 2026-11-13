class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] cost = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cost[row][col] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        cost[0][0] = 0;
        minHeap.offer(new int[] {0, 0, cost[0][0]});

        while (!minHeap.isEmpty()) {
            int[] cellWithCost = minHeap.poll();
            int[] cell = new int[] {cellWithCost[0], cellWithCost[1]};

            for (int[] direction : DIRECTIONS) {
                int nextRow = cell[0] + direction[0];

                if (nextRow < 0 || nextRow >= rows) {
                    continue;
                }

                int nextCol = cell[1] + direction[1];
                if (nextCol < 0 || nextCol >= cols) {
                    continue;
                }

                int diff = Math.abs(heights[cell[0]][cell[1]] - heights[nextRow][nextCol]);
                int newCost = Math.max(cost[cell[0]][cell[1]], diff);

                if(newCost < cost[nextRow][nextCol]){
                     cost[nextRow][nextCol] = newCost;
                    minHeap.offer(new int[] {nextRow, nextCol, newCost});
                }
               
            }
        }

        return cost[rows - 1][cols - 1];
    }
}

class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int area = markAndCalculateArea(row, col, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int markAndCalculateArea(int row, int col, int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        grid[row][col] = '0';

        int area = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] direction : DIRECTIONS) {
                int nextRow = cell[0] + direction[0];
                int nextCol = cell[1] + direction[1];

                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0
                    && nextCol < grid[0].length && grid[nextRow][nextCol] == 1) {
                    queue.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = '0';
                    area++;
                }
            }
        }
        return area;
    }
}

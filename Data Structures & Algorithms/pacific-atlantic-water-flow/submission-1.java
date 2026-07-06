class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = flow(heights, 0, 0);
        boolean[][] atlantic = flow(heights, heights.length - 1, heights[0].length - 1);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private boolean[][] flow(int[][] heights, int rowStart, int colStart) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] result = new boolean[rows][cols];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            queue.add(new int[] {i, colStart});
            result[i][colStart] = true;
        }

        for (int i = 0; i < cols; i++) {
            queue.add(new int[] {rowStart, i});
            result[rowStart][i] = true;
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int height = heights[position[0]][position[1]];

            for (int[] direction : DIRECTIONS) {
                int row = position[0] + direction[0];
                int col = position[1] + direction[1];

                if (row < 0 || row >= rows || col < 0 || col >= cols) {
                    continue;
                }

                if (result[row][col]) {
                    continue;
                }

                if (heights[row][col] < height) {
                    continue;
                }

                result[row][col] = true;
                queue.add(new int[] {row, col});
            }
        }

        return result;
    }
}

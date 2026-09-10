class Solution {
    public int uniquePaths(int m, int n) {
        int[] grid = new int[n];

        for(int i = 0; i < n; i++){
            grid[i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[j] +=  grid[j-1];
            }
        }

        return grid[n-1];
    }
}

//two decisions - move down or left
//for first row and col you can move only in one way

//curr field = number of moves in left cell + number of moves in top cell

// 1 1 1
// 1 2 3
// 1 3 6

//fill first row with 1
//first col is always 1

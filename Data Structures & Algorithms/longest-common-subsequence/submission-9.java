class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length();
        int cols = text2.length();

        int[][] mem = new int[rows + 1][cols + 1];

        for(int row = rows - 1; row >= 0; row--){
            for(int col = cols - 1; col >= 0; col--){
                
                if(text1.charAt(row) == text2.charAt(col)){
                    mem[row][col] = 1 + mem[row + 1][col + 1];

                }else{
                    mem[row][col] = Math.max(mem[row][col + 1], mem[row +1][col]);
                }   
            }
        }

        return mem[0][0];
    }
}

//  c a t
//c 3 2 1 0
//r 2 2 1 0
//a 2 2 1 0
//b 1 1 1 0
//t 1 1 1 0
//0 0 0 0 0
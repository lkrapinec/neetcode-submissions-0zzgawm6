class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length();
        int cols = text2.length();

        if(cols > rows){
            return longestCommonSubsequence(text2, text1);
        }

        int[] mem = new int[rows + 1];

        for(int row = rows - 1; row >= 0; row--){
            int prev = 0;
            for(int col = cols - 1; col >= 0; col--){
                int tmp = mem[col];
                if(text1.charAt(row) == text2.charAt(col)){
                    mem[col] = 1 + prev;

                }else{
                    mem[col] = Math.max(mem[col], mem[col +1]);
                }   
                prev = tmp;
            }
        }

        return mem[0];
    }
}

//  c a t
//c 3 2 1 0
//r 2 2 1 0
//a 2 2 1 0
//b 1 1 1 0
//t 1 1 1 0
//0 0 0 0 0
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 + length2 != s3.length()){
            return false;
        }

        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[length1][length2] = true;


        for(int i = length1; i >= 0; i--){
            for(int j = length2; j >= 0; j--){
                int index3 = i + j;
                if(i < length1 && s1.charAt(i) == s3.charAt(index3)){
                    dp[i][j] = dp[i+1][j];
                }

                if(j < length2 && !dp[i][j] && s2.charAt(j) == s3.charAt(index3)){
                    dp[i][j] = dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }
}

//. b  b  b _
//a 
//_       T T

class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for(int i = length1; i >= 0; i--){
            dp[i][length2] = length1 - i;
        }

        for(int j = length2; j >= 0; j--){
            dp[length1][j] = length2 -j;
        }

        for(int i = length1 - 1; i >= 0; i--){
            for(int j = length2 - 1; j >= 0; j--){
                dp[i][j] = dp[i+1][j+1];
                if(word1.charAt(i) != word2.charAt(j)){
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
                    dp[i][j]++;
                }
            }
        }

        return dp[0][0];

    }
}

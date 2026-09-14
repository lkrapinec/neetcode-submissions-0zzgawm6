class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.sort(coins);
        
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }

        for(int i  = coins.length - 1; i >= 0; i--){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i]){
                    dp[i][j] = dp[i+1][j];
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }

        return dp[0][amount];


    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }
}

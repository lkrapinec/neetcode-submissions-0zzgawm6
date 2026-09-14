class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i  = coins.length - 1; i >= 0; i--){
            for(int j = 1; j <= amount; j++){
                    dp[j] = dp[j] + (coins[i] <= j ? dp[j - coins[i]] : 0);
            }
        }

        return dp[amount];


    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i  = coins.length - 1; i >= 0; i--){
            int[] nextDP = new int[amount+1];
            nextDP[0] = 1;

            for(int j = 1; j <= amount; j++){
                nextDP[j] = dp[j];

                if(j -coins[i] >= 0 ){
                    nextDP[j] += nextDP[j - coins[i]];
                }
            }
            dp = nextDP;
        }

        return dp[amount];


    }
}

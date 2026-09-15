class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(Math.abs(target) > sum){
            return 0;
        }

        int dp[][] = new int[nums.length][sum * 2 + 1];
        dp[0][sum + nums[0]]++;
        dp[0][sum - nums[0]]++;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                dp[i][j] = 0;
                if(j - nums[i] >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if(j + nums[i] < dp[0].length){
                    dp[i][j] += dp[i- 1][j + nums[i]];
                }
                
            }
        }
        return dp[nums.length - 1][sum + target];
    }
}

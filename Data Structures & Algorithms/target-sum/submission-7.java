class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(Math.abs(target) > sum){
            return 0;
        }

        int dp[] = new int[sum * 2 + 1];
        dp[sum + nums[0]]++;
        dp[sum - nums[0]]++;

        for(int i = 1; i < nums.length; i++){
            int nextDP[]  = new int[sum * 2 + 1];
            for(int j = 0; j < dp.length; j++){
                nextDP[j] = 0;
                if(j - nums[i] >= 0){
                    nextDP[j] += dp[j - nums[i]];
                }
                if(j + nums[i] < dp.length){
                    nextDP[j] += dp[j + nums[i]];
                }
            }
            dp = nextDP;
        }
        return dp[sum + target];
    }
}

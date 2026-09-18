class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0 ;
        for (int num : nums) {
            sum += num;
        }
        if(sum < Math.abs(target)){
            return 0;
        }

        int[] dp = new int[sum * 2 + 1];
        dp[sum] = 1;
        for (int num : nums) {
            int[] nextDP = new int[dp.length];
            for (int i = 0; i < dp.length; i++) {
                if(dp[i] != 0){
                    nextDP[i - num] += dp[i];
                    nextDP[i + num] += dp[i];
                }
            }
            dp = nextDP;
        }
        return dp[sum + target];
    }
}

//-2, 2
//-4, 4

class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        int max = 1;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
                
            }
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int result = nums[0];

        int localSum = 0;
        for(int right = 0; right < length; right++){
           if (localSum < 0) {
                localSum = 0;
            }

            localSum += nums[right];
            result = Math.max(result, localSum);
            
        }

        return result;
    }
}

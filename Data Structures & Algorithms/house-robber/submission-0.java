class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }else if(length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // int first = nums[length - 1];
        // int second = nums[length - 2];
        nums[length - 3] +=  nums[length - 1];

        for(int i = length - 4; i >= 0; i--){
             nums[i] = Math.max(nums[i + 2],nums[i + 3]) + nums[i];
        }

        return Math.max(nums[0], nums[1]);
    }
}

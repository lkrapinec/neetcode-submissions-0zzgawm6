class Solution {
    public int rob(int[] nums) {
        int length = nums.length;

        if(length == 1){
            return nums[0];
        }

        // int[] dp = new int[length];

        int rob2 = nums[0];
        int rob1 = Math.max(nums[1], rob2);

        for(int i = 2; i < length; i++){
            int curr = Math.max(rob1, rob2 + nums[i]);
            rob2 = rob1;
            rob1 = curr;
        }

        return rob1;

    }
}

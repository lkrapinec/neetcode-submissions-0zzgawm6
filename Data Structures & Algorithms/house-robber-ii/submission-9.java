class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(houseRobber(0, nums.length - 1, nums), houseRobber(1, nums.length, nums));
    }

    private int houseRobber(int start, int end, int[] nums){
        int robber1 = 0;
        int robber2 = 0;

        for(int i = start; i < end; i++){
            int tmp = Math.max(robber1 + nums[i], robber2);
            robber1 = robber2;
            robber2 = tmp;
        }

        return robber2;
    }
}

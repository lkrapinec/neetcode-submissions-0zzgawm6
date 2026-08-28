class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        return Math.max(houseRobber(0,length - 1, nums), houseRobber(1, length, nums));
        // int rob1 = 0;
        // int rob2 = 0;
        // int start = 0;
        // int end = length;

        // if(length % 2 == 1){
        //     if(nums[0] < nums[length - 1]){
        //         start++;
        //     }else{
        //         end--;
        //     }
        // }
        // for(int i = start; i < end; i++){
        //     int tmp = Math.max(rob1 + nums[i], rob2);
        //     rob1 = rob2;
        //     rob2 = tmp;
        // }
        // return rob2;


    }

    private int houseRobber(int start, int end, int[] nums){
        int rob1 = 0;
        int rob2 = 0;

        for(int i = start; i < end; i++){
            int tmp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }
}

//2,9,8,3,6

//math.max(2,6), rob(8:3)
//9, rob(3:3)



class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        int max = nums[length - 1];
        int min = nums[length - 1];
        int result = nums[length - 1];


        for(int i = length - 2; i >= 0; i--){
            int curr = nums[i];

                int prevMax = max;
                max = Math.max(curr, curr * max);
                max = Math.max(max, curr * min);

                min = Math.min(curr, curr * min);
                min = Math.min(min, curr * prevMax);
           
            result = Math.max(max, result);
            result = Math.max(min, result);
        }


        return result;
    }

}

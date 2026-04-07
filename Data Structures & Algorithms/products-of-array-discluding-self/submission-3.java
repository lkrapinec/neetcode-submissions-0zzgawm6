class Solution {
    public int[] productExceptSelf(int[] nums) {
       int numsLength = nums.length;
       int[] result = new int[numsLength];

       int prefix = 1;
       for(int i = 0; i < numsLength; i++){
            result[i] = prefix;
            prefix *= nums[i];

       }

        int sufix = 1;
       for(int i = numsLength -1; i >= 0; i--){
            result[i] *= sufix;
            sufix *= nums[i];
       }

       return result;       
    }
}  
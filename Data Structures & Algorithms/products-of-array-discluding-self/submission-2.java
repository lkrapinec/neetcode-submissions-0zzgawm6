class Solution {
    public int[] productExceptSelf(int[] nums) {
       int numsLength = nums.length;
       int[] result = new int[numsLength];

       result[0] = 1;

       int mult = 1;
       for(int i = 0; i < numsLength - 1; i++){
            mult *= nums[i];
            result[i+1] = mult;
       }

        mult = 1;
       for(int i = numsLength -1; i > 0; i--){
            mult *= nums[i];
            result[i-1] *= mult;
       }

       return result;       
    }
}  
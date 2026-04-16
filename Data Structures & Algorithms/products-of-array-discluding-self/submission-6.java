class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int mult = 1;
        for(int i = 1; i < result.length; i++){
            mult *= nums[i-1];
            result[i] = mult;
        }
        
        mult = 1;
        for(int i = result.length -2; i > 0; i--){
            mult *= nums[i+1];
            result[i] *= mult;
        }

        result[0] = mult * nums[1];
        return result;
    }
}  

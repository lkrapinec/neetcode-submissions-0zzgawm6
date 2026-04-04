class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] result = new int[numsLength];

        boolean containsZero = false;
        for(int i = 0; i < numsLength; i++){
            for(int j = 0; j < numsLength; j++){
                if(j==i){
                    continue;
                }
                if(nums[i] == 0){
                    containsZero = true;
                }

                if(result[j] == 0 && !containsZero){
                    result[j] = nums[i];
                } 
                else{
                    result[j] *= nums[i];
                }
            }
        }
        return result;
    }
}  
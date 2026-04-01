class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];
        answer[0] = 1;

        int curr = 1;
        for(int i = 1; i < numsLength; i++){
            curr *= nums[i-1];
            answer[i] = curr; 
        }

        curr = 1;
        for(int i = numsLength -2; i >= 0; i--){
            curr *= nums[i+1];
            answer[i] *= curr;
        }
        return answer;
    }
}  

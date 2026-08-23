class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast){
                break;
            }
        }

        int result = 0;

        while(slow != result){
            slow = nums[slow];
            result = nums[result];
        }
        return result;
    }

    
}
//number represent index
//repeated integer creates a cycle
//
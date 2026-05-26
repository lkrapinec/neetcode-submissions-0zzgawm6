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

        int start = 0;
        while(true){
            slow = nums[slow];
            start = nums[start];
            if(slow == start){
                return slow;
            }
        }
    }
}

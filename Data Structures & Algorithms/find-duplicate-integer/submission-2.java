class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int start = 0;

        while(nums[slow] != nums[start]){
            slow = nums[slow];
            start = nums[start];
        }

        return nums[slow];
    }
}

//use fast and slow pointer to detect a loop
//values in list represent pointers to next element

//1,2,3,2,2
//0,1,2,3,4

//1->2->3->2->3->2->3->2->...

//slow and fast pointers
//1->2->3
//1->3->3

//new pointer from the start which value needs to be equal as slow pointer
//1->2->3 ->2
//1->2
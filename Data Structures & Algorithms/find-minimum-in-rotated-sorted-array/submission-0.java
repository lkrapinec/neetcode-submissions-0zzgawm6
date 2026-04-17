class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int middle = left + (right - left) / 2;

            if(nums[middle] > nums[right]){
                left = middle + 1;
            }else {
                right = middle;
            }
        }
        return nums[left];
    }
}

// [3,4,5,6,1,2]

// left = 3
// middle = 5
// right = 2

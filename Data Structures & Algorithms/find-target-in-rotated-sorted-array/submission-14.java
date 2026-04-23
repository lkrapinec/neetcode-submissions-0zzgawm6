class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middle = left + (right - left) / 2;

            if(nums[middle] == target){
                return middle;
            }
            //left side is sorted
            if(nums[left] <= nums[middle]){
                if(target >= nums[left] && target <= nums[middle]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }
            //right side is sorted
            else{
                if(target > nums[middle] && target <= nums[right]){
                    left = middle + 1;
                }else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
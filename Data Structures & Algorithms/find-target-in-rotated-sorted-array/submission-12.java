class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int middle = left + (right - left) / 2;

            if(nums[left] > nums[middle]){
                if(target <= nums[middle] || target >= nums[left]){
                    right = middle;
                }else {
                    left = middle + 1;
                }
            }else{
                if(target >= nums[left] && target <= nums[middle]){
                    right = middle;
                }else{
                    left = middle + 1;
                }
            }
        }

        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}


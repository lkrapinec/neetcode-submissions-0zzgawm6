class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            int middle = left + (right - left) / 2;

            if(nums[middle] == target){
                return middle;
            }

            if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }

        return -1;
    }
}

//implement binary search
//take middle element, if that element equal to target, then return
//if element is smaller than target search right part of array, otherwise search left part
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    private int binarySearch(int[] nums, int target, boolean findFirst){
        int left = 0; 
        int right = nums.length - 1;
        int result = -1;
        while(left <= right){
            int mid = left + (right - left) /2;

            if(nums[mid] < target){
                left = mid + 1;
                continue;
            }
            if(nums[mid] > target){
                right = mid -1;
                continue;
            }

            result = mid;
            if(findFirst){
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }
        return result;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right){
            int middle = left + (right -left) / 2;
            if(nums[left] > nums[right]){
                if(nums[middle] < nums[left]){
                    right = middle;
                }else{
                    left = middle + 1;
                }
            }else{
                if(nums[middle] >= nums[left]){
                    right = middle;
                }else{
                    left = middle + 1;
                }
            }
        }

        return nums[left];
    }
}
//binary search
//take middle element

//1,2,3,4,5,6
//2,3,4,5,6,1
//3,4,5,6,1,2
//4,5,6,1,2,3
//5,6,1,2,3,4
//6,1,2,3,4,5

//lets see first and last element for each iteration
//connection between first, last and middle element
//first > last && middle < first -> smallest in left
//                middle > first -> smallest in right

//first < last && middle > first -> smallest in left
//                middle < first -> assume that smallest is in right
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if(target == nums[start]){
            return start;
        }

        if(target == nums[end]){
            return end;
        }
        
        while(start < end){
            int middle = start + ((end - start) / 2);
            int middleValue = nums[middle];

            if(middleValue == target){
                return middle;
            }

            if(middle == start || middle == end){
                break;
            }


            if(target > middleValue){
                start = middle;
            }else {
                end = middle;
                
            }
        }
        return -1;
    }
}

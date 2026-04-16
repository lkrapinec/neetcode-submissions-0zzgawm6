class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        if(target == nums[start]){
            return start;
        }

        int end = nums.length - 1;
        if(target == nums[end]){
            return end;
        }
        
        while(start < end){
            int middle = start + ((end - start) / 2);

            if(target == nums[middle]){
                return middle;
            }

            if(middle == start || middle == end){
                break;
            }


            if(target > nums[middle]){
                start = middle;
            }else {
                end = middle;
                
            }
        }
        return -1;
    }
}

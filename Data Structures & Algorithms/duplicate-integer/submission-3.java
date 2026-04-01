class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> distinctIntegers = new HashSet<>();

        int length = nums.length;
        for(int currPosition = 0; currPosition  < length; currPosition++){
             if(distinctIntegers.contains(nums[currPosition])){
                return true;
             }

             distinctIntegers.add(nums[currPosition]);
        }
        return false;
    }
}
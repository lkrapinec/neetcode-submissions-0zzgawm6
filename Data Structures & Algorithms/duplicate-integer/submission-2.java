class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> numberCount = new HashMap<>();

        int length = nums.length;
        for(int currPosition = 0; currPosition  < length; currPosition++){
             if(numberCount.containsKey(nums[currPosition])){
                return true;
             }

             numberCount.put(nums[currPosition], 1);
        }
        return false;
    }
}
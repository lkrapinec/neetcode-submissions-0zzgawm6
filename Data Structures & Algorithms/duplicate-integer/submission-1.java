class Solution {
    public boolean hasDuplicate(int[] nums) {
     Set<Integer> noDuplicates = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(noDuplicates.contains(nums[i])){
                return true;
            }

            noDuplicates.add(nums[i]);
        }
    return false;
    }
}

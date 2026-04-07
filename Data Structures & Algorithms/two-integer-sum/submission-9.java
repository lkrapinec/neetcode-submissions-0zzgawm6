class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        Map<Integer, Integer> pair = new HashMap<>();

        int numsLength = nums.length;
        for(int i = 0; i < numsLength; i++){
            Integer firstPositon = pair.get(target - nums[i]);
            if(firstPositon != null){
                return new int[]{firstPositon, i};
            }

            pair.put(nums[i],i);
        }

        return new int[0];
    }
}

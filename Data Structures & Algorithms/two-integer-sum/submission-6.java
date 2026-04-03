class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> foundValues = new HashMap<>();

        int size = nums.length;
        for(int i = 0; i < size; i++){
            int targetValue = target - nums[i];

            if(foundValues.containsKey(targetValue)){
                return new int[]{foundValues.get(targetValue), i};
            }

            foundValues.put(nums[i], i);
        }

        return null;
    }

}




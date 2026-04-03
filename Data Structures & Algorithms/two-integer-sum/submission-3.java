class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> foundValues = new HashMap<>();

        int size = nums.length;
        for(int i = 0; i < size; i++){
            int value = nums[i];
            int targetValue = target - value;

            if(foundValues.containsKey(targetValue)){
                return new int[]{foundValues.get(targetValue), i};
            }

            foundValues.put(value, i);
        }

        return null;
    }

}




class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0,1);

        int result = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            Integer count = prefixSumToCount.get(sum - k);
            if(count != null){
                result += count;
            }

            Integer newCount = prefixSumToCount.computeIfAbsent(sum,c -> 0) + 1;
            prefixSumToCount.put(sum, newCount);
        }

        return result;
    }
}
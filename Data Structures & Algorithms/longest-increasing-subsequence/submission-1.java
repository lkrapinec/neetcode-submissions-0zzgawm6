class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = nums.length - 1; i >= 0; i--){
            int curr = nums[i];
            // if(map.containsKey(curr)){
            //     continue;
            // }

            int subsequence = 0;
            for(Integer key : map.keySet()){
                if(key > curr){
                    subsequence = Math.max(subsequence, map.get(key));
                }
            }
            subsequence++;
            map.put(curr, subsequence);
            result = Math.max(result, subsequence);
        }
        return result;
    }

    
}

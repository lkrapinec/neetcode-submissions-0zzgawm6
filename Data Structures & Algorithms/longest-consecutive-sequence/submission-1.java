class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int maxValue = 0;

        for(int i : set){
            if(!set.contains(i-1)){
                int max = i+1;
                while(set.contains(max)){
                    max++;
                }
                maxValue = Math.max(maxValue, max- i);
            }
        }
        return maxValue;

    }
    
}

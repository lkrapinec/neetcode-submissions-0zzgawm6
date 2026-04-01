class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int maxValue = 0;

        for(int i : nums){
            if(!set.contains(i-1)){
                int currentSize = 1;
                int counter = 1;
                while(set.contains(i+counter)){
                    currentSize++;
                    counter++;
                }
                if(maxValue < currentSize){
                    maxValue = currentSize;
                }
            }
        }
        return maxValue;

    }
    
}

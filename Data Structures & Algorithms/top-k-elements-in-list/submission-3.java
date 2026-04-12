class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countElements = new HashMap<>();

        for(int num : nums){
            Integer count = countElements.get(num);
            if(count == null){
                count = 0;
            }
            countElements.put(num, ++count);
        }

        List<Integer>[] frequency = new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry : countElements.entrySet()){
            if(frequency[entry.getValue()] == null){
                frequency[entry.getValue()] = new ArrayList<>();
            }
            
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] topKElements = new int[k];
        int count = 0;
        for(int i = nums.length; i >= 0; i--){
            if(frequency[i] != null){
                for(Integer integer : frequency[i]){
                    topKElements[count] = integer;
                    count++;

                    if(count >= k){
                        return topKElements;
                    }
                }

            }
        }

        return topKElements;
    }
}

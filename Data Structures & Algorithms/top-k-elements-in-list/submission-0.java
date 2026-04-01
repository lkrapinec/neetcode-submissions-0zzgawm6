class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] frequency = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            if(frequency[count] == null){
                frequency[count] = new ArrayList<Integer>();
            }

            frequency[count].add(entry.getKey());
        }
        int[] result = new int[k];
        int counter = 0;
        for(int i = frequency.length -1; i >= 0; i--){
            if(frequency[i] != null){
                List<Integer> x = frequency[i];
                for(int element : x){
                    result[counter++] = element;
                    if(counter >= k){
                        return result;
                    }
                }
            }
        }
        return result;
    }
}

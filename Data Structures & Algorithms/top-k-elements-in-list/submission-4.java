class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countedNumbers = new HashMap<>();

        for(int num : nums){
            Integer count = countedNumbers.get(num);
        if(count == null){
            count = 0;
        }
        countedNumbers.put(num, ++count);

        }

        List<Integer>[] sortedCountedNumbers = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : countedNumbers.entrySet()){
            if(sortedCountedNumbers[entry.getValue()] == null){
                List<Integer> values = new ArrayList<>();
                values.add(entry.getKey());

                sortedCountedNumbers[entry.getValue()] = values;
            }else {
                
                sortedCountedNumbers[entry.getValue()].add(entry.getKey());
            }
        }

        int counter = 0;
        int[] result = new int[k];
        for(int i = sortedCountedNumbers.length-1; i >= 0; i--){
            List<Integer> values = sortedCountedNumbers[i];
            
            if(values == null){
                continue;
            }

            for(int value : values){
                result[counter++] = value;
                if(counter >= k){
                    return result;
                }
            }
        }
        return result;

    }
}
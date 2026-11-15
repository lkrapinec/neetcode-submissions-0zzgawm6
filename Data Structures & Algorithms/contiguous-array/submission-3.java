class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToPosition = new HashMap<>();
        sumToPosition.put(0, -1);

        int result = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum--;
            }else{
                sum++;
            }

            if(!sumToPosition.containsKey(sum)){
                sumToPosition.put(sum, i);
            }else{
                result = Math.max(result, i - sumToPosition.get(sum));
            }
        }
        return result;

    }
}

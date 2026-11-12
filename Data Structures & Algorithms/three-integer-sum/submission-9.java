class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        
        calculateSum(0, 0, new ArrayList<>(), result, nums);

        return result;
    }

    private void calculateSum(int currPosition, int sum, List<Integer> comb, List<List<Integer>> result, int[] nums){

        if(comb.size() == 3){
            if(sum == 0){
                result.add(new ArrayList<>(comb));
            }
            return;
        }

        for(int i = currPosition; i < nums.length; i++){
            comb.add(nums[i]);
            calculateSum(i + 1, sum + nums[i], comb, result, nums);
            comb.remove(comb.size() - 1);

            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
    }
}


//does it make sense to first sort the array

//[-4,-1,-1,0,1,2]
//I will pick first number and then look for two other numbers which sum is equal to first num
//


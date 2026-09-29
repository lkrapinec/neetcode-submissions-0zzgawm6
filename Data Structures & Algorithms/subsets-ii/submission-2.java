class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        backtracking(0, nums, new ArrayList<>(), result);
                
        return result;
    }

    private void backtracking(int position, int[] nums, List<Integer> combination, List<List<Integer>> result){
        // if(position > nums.length){
        //     return;
        // }

        result.add(new ArrayList(combination));

        for(int i = position; i < nums.length; i++){
            if(i != position && nums[i] == nums[i-1]){
                continue;
            }

            combination.add(nums[i]);
            backtracking(i+1, nums, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}

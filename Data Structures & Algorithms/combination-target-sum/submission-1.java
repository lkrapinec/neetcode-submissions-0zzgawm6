class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // for(int i = 0; i < nums.length; i++){
            dfs(0, nums, target, result, new ArrayList<>());

        // }
        

        return result;
    }

    private void dfs(int start, int[] nums, int target, List<List<Integer>> result, List<Integer> combination){
        if(target == 0){
            List<Integer> validCombination = new ArrayList<>();
            for(int num : combination){
                validCombination.add(num);
            }
            result.add(validCombination);
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(target - nums[i] >= 0){
                combination.add(nums[i]);
                dfs(i, nums, target - nums[i], result, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
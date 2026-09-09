class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
         dfs(0, nums, target, result, new ArrayList<>());        

        return result;
    }

    private void dfs(int start, int[] nums, int target, List<List<Integer>> result, List<Integer> combination){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(target - nums[i] < 0){
                break;
            }
                combination.add(nums[i]);
                dfs(i, nums, target - nums[i], result, combination);
                combination.remove(combination.size() - 1);
        }
    }
}
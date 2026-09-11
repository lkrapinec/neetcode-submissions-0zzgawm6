class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        // result.add(combination);

        // for (int i = 0; i < nums.length; i++) {
            dfs(0, nums, result, combination);
        // }

        return result;
    }

    private void dfs(
        int position, int[] nums, List<List<Integer>> result, List<Integer> combination) {

        result.add(new ArrayList<>(combination));
        

        for (int i = position; i < nums.length; i++) {
            combination.add(nums[i]);
            dfs(i + 1, nums, result, combination);
            combination.remove(combination.size() - 1);
        }


    }
}
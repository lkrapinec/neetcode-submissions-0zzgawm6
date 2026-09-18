class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, result);

        return result;
    }

    private void dfs(int position, int[] nums, List<List<Integer>> result) {
        if (position == nums.length) {
            List<Integer> combination = new ArrayList<>();
            for (int num : nums) {
                combination.add(num);
            }

            result.add(combination);

            return;
        }

        for (int i = position; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] = nums[position];
            nums[position] = tmp;

            dfs(position + 1, nums, result);

            nums[position] = nums[i];
            nums[i] = tmp;
        }
    }
}

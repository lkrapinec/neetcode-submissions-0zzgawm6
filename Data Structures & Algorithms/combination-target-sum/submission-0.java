class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int target, int position, int sum, List<Integer> curr) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> list = new ArrayList<>(curr);
            result.add(list);
            return;

        }

        for (int i = position; i < nums.length; i++) {
            curr.add(nums[i]);
             dfs(nums, target, i, sum + nums[i], curr);
             curr.remove(curr.size() - 1);

        }
    }
}




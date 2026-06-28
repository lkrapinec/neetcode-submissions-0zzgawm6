class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, result);    

        return result;
    }

    private void backtrack(int start, List<Integer> curr, int[] nums, List<List<Integer>> result){
        result.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }

            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, result);
            curr.remove(curr.size() - 1);
        }
    }
}

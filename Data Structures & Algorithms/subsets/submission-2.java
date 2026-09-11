class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combination = new ArrayList <>();
    result.add(combination);

        for(int i = 0; i < nums.length; i++){
            dfs(i, nums, result, combination);
        }

        return result;
    }

    private void dfs(int position, int[] nums, List<List<Integer>> result, List<Integer> combination){
        if(position >= nums.length){
            return;
        }

        combination.add(nums[position]);
        

        for(int i = position + 1; i < nums.length; i++){
            dfs(i, nums, result, combination);
        }

        result.add(new ArrayList<>(combination));
        combination.remove(combination.size() - 1);
    }
}

//1
//1, 2
//1, 3
//1,2,3

//2
//2,3

//3

//each element can build subset only with elements after that element
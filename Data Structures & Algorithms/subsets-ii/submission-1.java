class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        backtracking(0, nums, new ArrayList<>(), result);
                
        return result;
    }

    private void backtracking(int position, int[] nums, List<Integer> combination, List<List<Integer>> result){
        if(position > nums.length){
            return;
        }

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

//backtracking(0, [1,2,1], [], [])
//result = [[]]
//i=0, combination = [1]
//backtracking(1, [1])
//result = [[], [1]]
//i=1, combination = [1,1]
//backtracking(2, [1,1])
//result = [[], [1], [1,1]]
//i=2, combination = [1,1,2]



//how to avoid duplicates
//sort array and use each unique number only once for backtracking
//1,1,2
//backtracking(1), backtracking(2)
//iterate through all combinations
//

//1
//1,1
//1,2
//1,1,2

//2

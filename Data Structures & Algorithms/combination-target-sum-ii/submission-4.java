class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(0, target, candidates, comb, result);

        return result;
    }

    private void backtrack(int position, int target,int[] candidates,List<Integer> comb,List<List<Integer>> result){

        
        if(target == 0){
            result.add(new ArrayList<>(comb));
            return;
        }

        if(position >= candidates.length){
            return;
        }

        if(target - candidates[position] >= 0){
            comb.add(candidates[position]);

            backtrack(position + 1, target - candidates[position], candidates, comb, result);
            comb.remove(comb.size() - 1);

        }
        while(position + 1 < candidates.length && candidates[position] == candidates[position + 1]){
            position++;
        }
        backtrack(position + 1, target, candidates, comb, result);

    }
}

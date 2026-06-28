class Solution {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtract(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    public void backtract(int[] candidates, int start, int target, List<Integer> combination, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            int candidate = candidates[i];

            if(candidate  > target){
                break;
            }

            if(i > start && candidate == candidates[i - 1]){
                continue;
            }

            combination.add(candidate);
            backtract(candidates, i + 1, target - candidate, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
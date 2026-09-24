class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        recursion(0,candidates, target, result, new ArrayList<>());

        return result;
    }

    private void recursion(int position, int[] candidates, int target, List<List<Integer>> result, List<Integer> combination){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }


        if(target < 0 || position >= candidates.length){
            return;
        }

        for(int i = position; i < candidates.length; i++){
            if(i > position && candidates[i - 1] == candidates[i]){
                continue;
            }
            combination.add(candidates[i]);
            recursion(i + 1, candidates, target - candidates[i], result, combination);
            combination.remove(combination.size() - 1);

        }

        
        // combination.add(candidates[position]);
        // recursion(position + 1, candidates, target - candidates[position], result, combination);
        // combination.remove(combination.size() - 1);

        // while(position + 1 < candidates.length && candidates[position] == candidates[position + 1])
        //     position++;
        // }
        // recursion(position + 1, candidates, target, result, combination);

    }
}

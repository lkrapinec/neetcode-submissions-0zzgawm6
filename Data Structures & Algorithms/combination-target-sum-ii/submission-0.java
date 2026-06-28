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

            if(target - candidate  < 0){
                break;
            }

            if(i > start && candidate == candidates[i - 1]){
                continue;
            }

            int size = combination.size();
            combination.add(candidate);
            backtract(candidates, i + 1, target - candidate, combination, result);
            combination.remove(size);
        }
    }
}


//put everything to set and sort it O(nlogn)
// i can impelent sort directly on array, and skip duplicated values
//1,2,2,3,4,9 , target = 8
//1, target = 7
//1, 2
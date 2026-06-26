class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int length = result.size();
            for (int i = 0; i < length; i++) {
                result.add(combineLists(num, result.get(i)));
            }
        }

        return result;
    }
    private List<Integer> combineLists(int num, List<Integer> comb){
        List<Integer> newList = new ArrayList<>();
        newList.add(num);
        for(Integer integer : comb){
            newList.add(integer);
        }

        return newList;
    }
}

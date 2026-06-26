class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int length = result.size();
            for (int i = 0; i < length; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(num);
                result.add(newList);
            }
        }

        return result;
    }

}

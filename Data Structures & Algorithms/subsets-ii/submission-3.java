class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); 
        int prev = 0;
        int curr = 0;


        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                curr = prev;
            }else{
                curr = 0;
            }

            prev = result.size();
            for(int j = curr; j < prev; j++){
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }

        return result;

    }
}

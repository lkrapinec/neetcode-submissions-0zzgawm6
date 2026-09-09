class Solution {
    public boolean canPartition(int[] nums) {
       Map<Integer,Boolean> map = new HashMap<>();

       return dfs(0, 0, nums, map);
    }

    private boolean dfs(int position, int sum, int[] nums, Map<Integer,Boolean> map){
        if(map.containsKey(sum)){
            return map.get(Math.abs(sum));
        }

        if(position >= nums.length){
            return false;
        }

        if(position == nums.length - 1){
            return sum + nums[position] == 0 || sum - nums[position] == 0;
        }

        if(dfs(position + 1, sum + nums[position], nums, map)){
            map.put(Math.abs(sum + nums[position]), true);
            return true;
        }
        if(dfs(position + 1, sum - nums[position], nums, map)){
            map.put(Math.abs(sum - nums[position]), true);
            return true;
        }

        map.put(Math.abs(sum + nums[position]), false);
        map.put(Math.abs(sum - nums[position]), false);
        return false;
    }
}
//put each number in one or other subset


//memoize result   

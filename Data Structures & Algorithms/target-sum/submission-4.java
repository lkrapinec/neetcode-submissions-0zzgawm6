class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int[][] mem = new int[nums.length][sum * 2 + 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < mem[0].length; j++){
                mem[i][j] = Integer.MIN_VALUE;
            }
            
        }

        return dfs(0, target, nums, mem, sum);
    }

    private int dfs(int position, int target, int[] nums, int[][] mem, int sum){
        if(position == nums.length){
            return target == 0 ? 1 : 0;
        }

        int index = target + sum;
        if(index < 0 || index >= mem[0].length){
            return 0;
        }

        if(mem[position][index] != Integer.MIN_VALUE){
            return mem[position][index];
        }

        mem[position][index] = dfs(position + 1, target - nums[position], nums, mem, sum) + dfs(position + 1, target + nums[position], nums, mem, sum);

        return mem[position][index];
    }
}




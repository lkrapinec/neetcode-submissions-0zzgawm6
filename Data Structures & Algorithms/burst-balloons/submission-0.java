class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[][] mem = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                mem[i][j] = -1;
            }
        }

        return dfs(0, length - 1, nums, mem);


    }

    private int dfs(int left, int right, int[] nums, int[][] mem){
        if(left > right){
            return 0;
        }

        if(mem[left][right] != -1){
            return mem[left][right];
        }

        int result = 0;
        for(int i = left; i <= right; i++){
            if(i >= 0){
                int tmp = nums[i];
                if(left > 0){
                    tmp *= nums[left - 1];
                }

                if(right + 1 < nums.length){
                    tmp *= nums[right + 1];
                }
                tmp += dfs(left, i - 1, nums, mem) + dfs(i + 1, right, nums, mem);

                result = Math.max(result, tmp);
            }
            
            
            
        }

        mem[left][right] = result;

        return result;
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if(length == 1){
            return cost[0];
        }

        int[] mem = new int[cost.length];

        mem[length - 1] = cost[length - 1];
        mem[length - 2] = cost[length - 2];

        for(int i = length - 3; i >= 0; i--){
            mem[i] = Math.min(mem[i + 1], mem[i + 2]) + cost[i];
        }

        return Math.min(mem[0], mem[1]);

    }
}

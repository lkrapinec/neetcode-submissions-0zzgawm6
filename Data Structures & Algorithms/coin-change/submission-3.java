class Solution {
    public int coinChange(int[] coins, int amount) {
        int mem[] = new int[amount + 1];

        return dfs(coins, amount, mem);
    }

    private int dfs(int[] coins, int amount, int mem[]){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(mem[amount] != 0){
            return mem[amount];
        }

        int min = -1;
        for(int coin : coins){
            int curr = dfs(coins, amount - coin, mem);
            if(curr >= 0 && (min == -1 || min > curr)){
                min = curr;
            }
        }

        if(min < 0){
            mem[amount] = min;
            return min;
        }

        mem[amount] = min + 1;
        return mem[amount];
    }
}

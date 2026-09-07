class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        for(int i = 1; i < mem.length; i++){
            mem[i] = Integer.MAX_VALUE;
        }
        // mem[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin > i || mem[i - coin] == Integer.MAX_VALUE){
                    continue;
                }


                mem[i] = Math.min(mem[i], 1 + mem[i - coin]);
            }
        }
        return mem[amount] == Integer.MAX_VALUE ? -1 : mem[amount];
    }

    
}


//amount[1] = 1
//amount[2] = 1 + amount[1]
//amount[3] = 1 + amount[2]
//amount[4] = 1 + amount[3]
//amount[5] = 5
class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[amount + 1][coins.length];
        for (int i = 0; i < amount + 1; i++) {
            for(int j = 0; j < coins.length;j++){
                mem[i][j] = -1;
            }
            
        }
        return recursion(0, amount, coins, mem);

    }

    private int recursion(int position, int amount, int[] coins, int[][] mem) {
        if (position >= coins.length || amount < 0) {
            return 0;
        }
        if (mem[amount][position] != -1) {
            return mem[amount][position];
        }

        if (amount == 0) {
            return 1;
        }

        int result = 0;
        for (int i = position; i < coins.length; i++) {
            result += recursion(i, amount - coins[i], coins, mem);
        }

        mem[amount][position] = result;

        return result;
    }
}

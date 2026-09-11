class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }

        return dfs(0,1,prices, dp);
        
    }

    private int dfs(int position, int buying, int[] prices, int[][] dp){
        if(position >= prices.length){
            return 0;
        }

        if(dp[position][buying] != -1){
            return dp[position][buying];
        }

        if(buying == 1){
            int buy = dfs(position + 1, 0, prices, dp) - prices[position];
            int skip = dfs(position + 1, 1, prices, dp);

            dp[position][buying] = Math.max(buy, skip);
        }else{
            int sell = dfs(position + 2, 1, prices, dp) + prices[position];
            int skip = dfs(position + 1, 0, prices, dp);

            dp[position][buying] = Math.max(sell, skip);
        }

        return dp[position][buying];
    }
}


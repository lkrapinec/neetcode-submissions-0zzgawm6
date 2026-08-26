class Solution {
    public int climbStairs(int n) { 
        int[] cache = new int[n];
        for(int i = 0; i < n; i++){
            cache[i] = -1;
        }
        return dfs(n, 0, cache);
    }

    private int dfs(int n, int i, int[] cache){
        if(i >= n){
            return i == n ? 1 : 0;
        }

        if(cache[i] == -1){
            cache[i] = dfs(n, i+1, cache) + dfs(n, i+2, cache);
        }
        return cache[i];
    }
}
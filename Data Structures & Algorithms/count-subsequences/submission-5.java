class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength < tLength){
            return 0;
        }

        int dp[] = new int[sLength + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        for(int i = tLength - 1; i >= 0; i--){
            int prev = dp[sLength];
            dp[sLength] = 0;
            int[] nextDP  = new int[sLength + 1];

            for(int j = sLength - 1; j >= 0; j--){
                int tmp = dp[j];
                dp[j] = dp[j+1];
                if(t.charAt(i) == s.charAt(j)){
                    dp[j] += prev;
                }
                prev = tmp;
            }
           
        }

        return dp[0];
    }
}
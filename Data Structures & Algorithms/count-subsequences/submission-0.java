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
            int[] nextDP  = new int[sLength + 1];
            for(int j = sLength - 1; j >= 0; j--){
                nextDP[j] = nextDP[j + 1];
                if(t.charAt(i) == s.charAt(j)){
                    nextDP[j] += dp[j + 1];
                }
            }
            dp = nextDP;
        }

        return dp[0];
    }
}

//. t c b a a t .
//c 2 2 0 0 0 0 0
//a 2 2 2 2 1 0 0
//t 2 1 1 1 1 1 0
//. 1 1 1 1 1 1 1

//for curr letter take max number of previous row
//if one letter shows multiple times, increase it


//. c a a a t .
//c
//a 0 3 2 1 0 0
//t 1 1 1 1 1 0
//. 1 1 1 1 1 1
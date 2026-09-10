class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() < text2.length()){
            longestCommonSubsequence(text2, text1);
        }
        
        int smallerLength = text2.length();
        int[] dp = new int[smallerLength + 1];

        for(int i = text1.length() - 1; i >= 0; i--){
            int prev = 0;
            for(int j = smallerLength - 1; j >= 0; j--){
                int tmp = dp[j];
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[j] = 1 + prev;
                }else{
                    dp[j] = Math.max(dp[j], dp[j+1]);
                }
                prev = tmp;
            }
        }

        return dp[0];
    }
}

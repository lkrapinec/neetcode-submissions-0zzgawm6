class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(length1 < length2){
            return isInterleave(s2, s1, s3);
        }

        if(length1 + length2 != s3.length()){
            return false;
        }


        boolean[] dp = new boolean[length2 + 1];
        dp[length2] = true;


        for(int i = length1; i >= 0; i--){
            boolean nextDP = (i == length1 ? true : false);
            for(int j = length2; j >= 0; j--){
                int index3 = i + j;

                boolean result = (j < length2 ? false : nextDP);
                if(i < length1 && s1.charAt(i) == s3.charAt(index3)){
                    result = dp[j];
                }

                if(j < length2 && !dp[j] && s2.charAt(j) == s3.charAt(index3) && nextDP){
                    result = true;
                }
                dp[j] = result;
                nextDP = dp[j];
            }
        }

        return dp[0];
    }
}

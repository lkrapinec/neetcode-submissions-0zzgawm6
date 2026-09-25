class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        if(length1 < length2){
            return minDistance(word2, word1);
        }

        int[] dp = new int[length2 + 1];

        for(int i = length2; i >= 0; i--){
            dp[i] = length2 - i;
        }

        for(int i = length1 - 1; i >= 0; i--){
            int[] nextDP = new int[length2 + 1];
            nextDP[length2] = length1 - i;
            for(int j = length2 - 1; j >= 0; j--){
                nextDP[j] = dp[j+1];
                if(word1.charAt(i) != word2.charAt(j)){
                    nextDP[j] = Math.min(nextDP[j], Math.min(nextDP[j + 1], dp[j]));
                    nextDP[j]++;
                }
            }
            dp = nextDP;
        }

        return dp[0];

    }
}

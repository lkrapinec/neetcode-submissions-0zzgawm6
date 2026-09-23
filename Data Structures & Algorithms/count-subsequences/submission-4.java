class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return 0;
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);

        for (int i = n - 1; i >= 0; i--) {
            int prevDiagonal = dp[m];
            dp[m] = 0;

            for (int j = m - 1; j >= 0; j--) {
                int oldDpJ = dp[j];

                dp[j] = dp[j + 1];

                if (t.charAt(i) == s.charAt(j)) {
                    dp[j] += prevDiagonal;
                }

                prevDiagonal = oldDpJ;
            }
        }

        return dp[0];
    }
}
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> combination = new ArrayList<>();

        int sLength = s.length();

        boolean[][] dp = new boolean[sLength][sLength];
        for(int length = 1; length <= sLength; length++){
            for(int left = 0; left <= sLength - length; left++){
                dp[left][left + length - 1] = s.charAt(left) == s.charAt(left + length - 1)
                && (left + 1 > (left + length - 2) || dp[left + 1][left + length - 2]);
            }
        }

        createSubstrings(0, s, combination, result, dp);

        return result;
    }

    private void createSubstrings(
        int left, String s, List<String> combination, List<List<String>> result, boolean[][] dp) {
        if (left >= s.length()) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int right = left; right < s.length(); right++) {
            if (dp[left][right]) {
                combination.add(s.substring(left, right + 1));
                createSubstrings(right + 1, s, combination, result, dp);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
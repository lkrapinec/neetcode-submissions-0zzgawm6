class Solution {
    public String longestPalindrome(String s) {
        int[] result = new int[2];

        for (int i = 0; i < s.length(); i++) {
            isPalidrome(i,i,s,result);
            isPalidrome(i,i+1,s,result);
        }

        return s.substring(result[0], result[1] + 1);
    }

    private void isPalidrome(int start, int end, String s, int[] result){
         while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (end - start > result[1] - result[0]) {
                    result[0] = start;
                    result[1] = end;
                }

                start--;
                end++;
            }
    }
}

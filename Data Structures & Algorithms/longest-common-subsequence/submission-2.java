class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() < text2.length()){
            longestCommonSubsequence(text2, text1);
        }
        
        int smallerLength = text2.length();
        int[] prev = new int[smallerLength + 1];
        int[] curr = new int[smallerLength + 1];

        for(int i = text1.length() - 1; i >= 0; i--){
            for(int j = smallerLength - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = 1 + prev[j + 1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j+1]);
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        return prev[0];
    }
}

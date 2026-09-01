class Solution {
    public String longestPalindrome(String s) {
        int resultStart = 0;
        int resultEnd = 0;

        for(int i = 0; i < s.length(); i++){
            int start = i;
            int end = i;

            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                if(end - start > resultEnd - resultStart){
                    resultStart = start;
                    resultEnd =end;
                }

                start--;
                end++;
            }

            start = i;
            end = i + 1;

                       while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                if(end - start > resultEnd - resultStart){
                    resultStart = start;
                    resultEnd =end;
                }

                start--;
                end++;
            }
        }

        return s.substring(resultStart, resultEnd + 1);
    }
}

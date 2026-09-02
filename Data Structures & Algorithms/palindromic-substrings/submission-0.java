class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            result += countPalidrome(i,i,s);
            result += countPalidrome(i,i + 1,s);
        }

        return result;
    }

    private int countPalidrome(int start, int end, String s){
        int result = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            result++;
            start--; 
            end++;
        }

        return result;
    }
}

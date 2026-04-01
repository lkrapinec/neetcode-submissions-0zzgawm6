class Solution {
    public boolean isAnagram(String s, String t) {
        int length = 'z' - 'a' + 1;

        int[] countChars = new int[length];
        for(int i = 0; i < s.length(); i++){
            int currPosition = s.charAt(i) - 'a';

            countChars[currPosition] += 1;
        }

        for(int i = 0;  i < t.length(); i++){
            int currPosition = t.charAt(i) - 'a';

            if(countChars[currPosition] <= 0){
                return false;
            }

            countChars[currPosition] -= 1;
        }

        for(int i = 0; i < length; i++){
            if(countChars[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

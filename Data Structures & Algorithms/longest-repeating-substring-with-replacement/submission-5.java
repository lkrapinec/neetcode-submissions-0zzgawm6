class Solution {
    public int characterReplacement(String s, int k) {
        int[] characterCount = new int['Z' - 'A' + 1];

        int result = 0;
        int left = 0;
        int maxCharacter = 0;
        int windowSize = 0;

        for(int right = 0; right < s.length(); right++){
            int characterIndex = s.charAt(right) - 'A';

            maxCharacter = Math.max(maxCharacter, ++characterCount[characterIndex]);
            windowSize++;

            while(windowSize - maxCharacter > k){
                    characterCount[s.charAt(left) - 'A']--;
                    windowSize--;
                    left++;
            }
            result = Math.max(result, windowSize);
        } 
        return result;
    }
}
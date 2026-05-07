class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        int[] characterCount = new int['Z' - 'A' + 1];
        int maxCharacter = 0;

        for(int right = 0; right < s.length(); right++){
            characterCount[s.charAt(right) - 'A']++;

            maxCharacter = Math.max(maxCharacter, characterCount[s.charAt(right) - 'A']);
            int characterSum = right - left + 1;

            //numbers of characters that needs to be replaced
            while(characterSum - maxCharacter > k){
                    characterCount[s.charAt(left) - 'A']--;
                    maxCharacter = Math.max(maxCharacter, characterCount[s.charAt(left) - 'A']);
                    characterSum--;
                    left++;
            }
            result = Math.max(result, characterSum);
        } 
        return result;
    }
}
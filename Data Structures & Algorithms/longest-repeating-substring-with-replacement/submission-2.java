class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        int[] characterCount = new int['Z' - 'A' + 1];

        for(int right = 0; right < s.length(); right++){
            characterCount[s.charAt(right) - 'A']++;

            //numbers of characters that needs to be replaced
            while(left < s.length() ){
                int maxCharacterPosition = 0;
                int characterSum = 0;
                for(int i = 0; i < characterCount.length; i++){
                    characterSum += characterCount[i];
                    maxCharacterPosition = characterCount[maxCharacterPosition] < characterCount[i] ? i : maxCharacterPosition;
                }

                characterSum -= characterCount[maxCharacterPosition];

                if(characterSum > k){
                    characterCount[s.charAt(left) - 'A']--;
                    left++;

                }else{
                    result = Math.max(result, characterSum + characterCount[maxCharacterPosition]);
                    break;
                }
            }
        } 
        return result;
    }
}

//move right pointer and add increase counter for current letter
//sum count of letters, but ignore highest number
//if sum is bigger than k, move left pointer and substract count for that letter
//move left pointer until there are only k different elemnts in array

//memorize biggest substring
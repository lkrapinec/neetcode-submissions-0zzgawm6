class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        
        int[] chars = new int[26];
        char mostFrequent = s.charAt(0);
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            chars[curr - 'A']++;

            if(chars[mostFrequent - 'A'] < chars[curr - 'A']){
                mostFrequent = curr;
            }

            int others = right - left - chars[mostFrequent - 'A'];
            while(others >= k){
                char leftChar = s.charAt(left);
                chars[leftChar - 'A']--;
                left++;
                others--;
            }

            result = Math.max(right - left + 1, result);
        }

        return result;
    }
}

//sliding window

//brute force
//chose character with maximum frequency and increase a window until there are more than k number of characters that are not maximum frequency character

//do this for each position in an array
//complexity n positions and increase a window up to n times -> O(n**2)

//can we do better
//can we visit each character one time -> O(n) time complexity

//visit each character one time
//increase a window until there are at least  k different characters
//memorize number of each character in case that most frequent character changes
//if there are more than k different characters, then decrease left side of the widow until window does not becomes valid again
//find most frequent character
//store maximum valid window

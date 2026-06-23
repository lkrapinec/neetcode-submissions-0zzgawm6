class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        int[] letterCount = new int[26];

        int res = 0;

        int left = 0;
        int maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            letterCount[curr - 'A']++;
            maxFreq = Math.max(maxFreq, letterCount[curr - 'A']);
            
            int length = (right - left + 1);
            if(length - maxFreq > k){
                letterCount[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);

        }

        return res;
    }
}

// up to k characters can be ignored

// one pointer for start, and another for the end
// calculate max length
// memorize how many different characters must be replaced
// memorize most frequent character
// if replaced characters are less than k or curr char is most frequent, then move right pointer
// otherwise move left until replaced chars are equal to k

// how to count each char
// have array and
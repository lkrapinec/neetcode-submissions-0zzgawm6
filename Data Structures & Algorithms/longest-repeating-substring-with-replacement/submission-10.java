class Solution {
    public int characterReplacement(String s, int k) {
        int[] characters = new int[26];

        int result = 0;

        int mostFrequentPosition = charPosition(s.charAt(0));
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            int position = charPosition(s.charAt(right));

            characters[position]++;
            if(characters[position] > characters[mostFrequentPosition]){
                mostFrequentPosition = position;
            }

            int mostFrequent = characters[mostFrequentPosition];
            while(right - left + 1 -  mostFrequent> k){
                int leftPosition = charPosition(s.charAt(left));
                characters[leftPosition]--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    private int charPosition(char c){
        return c - 'A';
    }
}

//number of most frequent character
//number of other characters

//array with number of each char
//other chars = sliding window size - number of most frequent character
//what is most frequent character changes
//compare number of new char to most frequent char and replace it if needed
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charInWindow = new HashMap<>();

        int maxLength = 0;

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            Integer position = charInWindow.get(curr);

            //char is in window
            if(position != null){
                left = Math.max(left, position + 1);
            }

            charInWindow.put(curr, right);
            maxLength = Math.max(maxLength, right - left + 1);
            continue;

        }

        return maxLength;
    }
}

//exapnd window until same character is in the window
//how to know if char is in window
//use array of fixed length to mark chars in window
//if same char is in window, then move left side until char is out, comapre with max size
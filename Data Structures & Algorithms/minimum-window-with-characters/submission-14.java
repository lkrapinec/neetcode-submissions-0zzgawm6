class Solution {
    public String minWindow(String s, String t) {
        int[] numberOfChars = new int[52];
        int tLength = t.length();

        for (char c : t.toCharArray()) {
            int position = charToPosition(c);
            numberOfChars[position]++;
        }

        int[] result = new int[]{-1, s.length()};

        int[] foundNumberOfChars = new int[52];
        int found = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            int currPosition = charToPosition(curr);

            if(numberOfChars[currPosition] == 0){
                continue;
            }

            foundNumberOfChars[currPosition]++;
            if(foundNumberOfChars[currPosition] > numberOfChars[currPosition]){
                continue;
            }

            found++;
            while(found == tLength){
                if(right - left < result[1] - result[0]){
                    result[1] = right;
                    result[0] = left;
                }

                char leftChar = s.charAt(left);
                int leftPosition = charToPosition(leftChar);

                if(foundNumberOfChars[leftPosition] > 0){
                    if(foundNumberOfChars[leftPosition] <= numberOfChars[leftPosition]){
                        found--;
                    }
                    foundNumberOfChars[leftPosition]--;
                }

                left++;
            }
        }

        if(result[0] == -1){
            return "";
        }

        return s.substring(result[0], result[1] + 1);
    }

    private int charToPosition(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }

        return c - 'a' + 'Z' - 'A' + 1;
    }
}

// sliding window
// increase sliding window until all characters are present
// use array to count characters in t
// reduce window until substrings becomes invalid
// update result while reducing window

// time complexity: each character is visited only once so it will take the size of s O(s)
// space complexity: string contains only uppercase and lowercase letter, fixed number -> O(1)

// how to know if we hav all characters -> curr char needs to have same number as t and other chars
// need to have valid numbner
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        int[] chars = new int[52];
        for(char c : t.toCharArray()){
            int index = charToIndex(c);
            chars[index]++;
        }

        int[] existingChars = new int[52];
        int leftResult = -1;
        int rightResult = s.length();

        int validChars = 0;

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            int index = charToIndex(curr);

            if(chars[index] == 0){
                continue;
            }

            existingChars[index]++;
            if(existingChars[index] > chars[index]){
                continue;
            }

            validChars++;

            while(validChars >= t.length()){
                if(right - left < rightResult - leftResult){
                    rightResult = right;
                    leftResult = left;
                }


                int leftIndex = charToIndex(s.charAt(left));
                left++;

                if(chars[leftIndex] == 0){
                    continue;
                }

                existingChars[leftIndex]--;

                if(existingChars[leftIndex] < chars[leftIndex]){
                    validChars--;
                }
            }
        }
        if(leftResult == -1){
            return "";
        }
        return s.substring(leftResult, rightResult + 1);
    }

    private int charToIndex(char c){
        if(c >= 'A' && c <= 'Z'){
            return c -'A';
        }

        return c - 'a' + 26;
    }
}

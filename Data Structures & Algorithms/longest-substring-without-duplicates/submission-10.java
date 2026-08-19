class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        int left = 0;

        int result = 0;
        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            
            while(uniqueChars.contains(curr)){
                uniqueChars.remove(s.charAt(left));
                left++;
            }

            uniqueChars.add(curr);
            result = Math.max(right - left + 1, result);
        }
        return result;
    }
}
//how do I know which characters I have in a sliding window
//use set to store existing characters
//can we do better
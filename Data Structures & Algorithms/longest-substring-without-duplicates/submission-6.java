class Solution {
    public int lengthOfLongestSubstring(String s) {
         Map<Character, Integer> characterPosition = new HashMap<>();
        
        int longest = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            if(characterPosition.containsKey(s.charAt(right))){
                left = Math.max(characterPosition.get(s.charAt(right))+1, left);
            }
            characterPosition.put(s.charAt(right), right);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}

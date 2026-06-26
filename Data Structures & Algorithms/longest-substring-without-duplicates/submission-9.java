class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        Map<Character, Boolean> visited = new HashMap<>();
        int left = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(visited.get(c) != null && visited.get(c) == true){
                visited.put(s.charAt(left), false);
                result = Math.max(result, i - left);
                left++;
                
            }
            visited.put(c, true);
        }
        result = Math.max(result, s.length() - left);

        return result;
    }
}

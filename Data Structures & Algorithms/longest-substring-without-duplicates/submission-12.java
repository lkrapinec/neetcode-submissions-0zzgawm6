class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int result = 0;

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char curr = s.charAt(right);
            if(map.containsKey(curr)){
                left = Math.max(left, map.get(curr) + 1);
                
            }
            
            map.put(curr, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}

//use array to check if char is in a substring
//if yes, then move left pointer to position after char that is found in array
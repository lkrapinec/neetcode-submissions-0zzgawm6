class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c,0) + 1);
        }

        int need = countT.size();
        int res = -1;
        int resLen = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c,0) + 1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                need--;
            }

            while(need == 0){
                if((right - left + 1) < resLen){
                    resLen = right - left + 1;
                    res = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    need++;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res, res + resLen);
    }
}


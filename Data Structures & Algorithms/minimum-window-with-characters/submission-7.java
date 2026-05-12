class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        int[] countT = new int[128];
        int[] window = new int[128];

        for(char c : t.toCharArray()){
            countT[c]++;
        }

        int have = 0;
        int res = -1;
        int resLen = Integer.MAX_VALUE;
        int left = 0;

        int need = 0;
        for (int count : countT) {
            if (count > 0) {
                need++;
            }
        }

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            
            window[c]++;

        if(countT[c] > 0 && window[c] == (countT[c])){
                have++;
            }

            while(have == need){
                if((right - left + 1) < resLen){
                    resLen = right - left + 1;
                    res = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) {
                    have--;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res, res + resLen);
    }
}


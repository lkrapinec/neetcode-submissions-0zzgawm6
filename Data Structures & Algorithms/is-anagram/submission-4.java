class Solution {
    public boolean isAnagram(String s, String t) {
        char[] compare = new char[26];
        for(char c : s.toCharArray()){
            compare['z'- c]++;
        }
        for(char c : t.toCharArray()){
            compare['z'- c]--;
        }

        for(char c : compare){
            if(c != 0){
                return false;
            }
        }
        return true;
        }
    }


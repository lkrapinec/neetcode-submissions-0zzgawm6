class Solution {
    public boolean isAnagram(String s, String t) {
        int[] compare = new int[26];

        for(char c : s.toCharArray()){
            compare[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            compare[c - 'a']--;
        }

        for(int i : compare){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}

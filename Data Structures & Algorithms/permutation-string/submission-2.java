class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] permutation = new int['z' - 'a' + 1];
        int[] comparison = new int['z' - 'a' + 1];
        for(int i = 0; i < s1.length(); i++){
            permutation[s1.charAt(i) - 'a']++;
            comparison[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < comparison.length; i++){
            if(permutation[i] != comparison[i]){
                break;
            }
            if(i == comparison.length - 1){
                return true;
            }
        }

        for(int right = s1.length(); right < s2.length(); right++){
            comparison[s2.charAt(right) - 'a']++;
            comparison[s2.charAt(right - s1.length()) - 'a']--;

            
            for(int i = 0; i < comparison.length; i++){
                if(permutation[i] != comparison[i]){
                    break;
                }
                if(i == comparison.length - 1){
                    return true;
                }
            }
        }

        return false;
    }
}

//permutation -> count char in first array
//in second string create window of first array size
//compare to char count in first array
//if equals return true
//otherwise move by one

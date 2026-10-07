class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        findPalindrome(0, new ArrayList<>(), result, s);

        return result;
    }

    private void findPalindrome(int curr, List<String> combination, List<List<String>> result, String s){
        if(curr == s.length()){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int right = curr; right < s.length(); right++){
            if(isPalindrome(curr, right, s)){
                combination.add(s.substring(curr, right + 1));
                findPalindrome(right + 1, combination, result, s);
                combination.remove(combination.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int left, int right, String s){
        if(left > right){
            return true;
        }
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }

        return isPalindrome(left + 1, right - 1, s);
    }
}

//from curr char expand to right
//if expanded string is palindrome, then try to do that from right + 1
//if curr is length of string, then this is a valid combination
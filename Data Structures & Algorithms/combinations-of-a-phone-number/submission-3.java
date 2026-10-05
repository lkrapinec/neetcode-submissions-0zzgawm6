class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if(digits.length() == 0){
            return result;
        }

       String[] digitToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tvu", "wxyz"};

        StringBuilder sb = new StringBuilder();

        backtrack(0, digits, sb, digitToChars, result);

        return result;
    }

    private void backtrack(int position, String digits, StringBuilder sb, String[] digitToChars, List<String> result){
        if(position >= digits.length()){
            result.add(sb.toString());
            return;
        }

        char curr = digits.charAt(position);
        for(char c : digitToChars[curr - '0'].toCharArray()){
            sb.append(c);

            backtrack(position + 1, digits, sb, digitToChars, result);

            sb.setLength(sb.length() - 1);
        }
    }
}

//

//create map that will have key of number, and value as list of combinations
//for each number iterato through list and add value to combination
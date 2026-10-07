class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }
        String[] combinations = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"
        };

        
        dfs(0, digits, combinations, result, new StringBuilder());

        return result;
    }

    private void dfs(int i, String digits, String[] combinations, List<String> result, StringBuilder sb){
        if(i == digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char c : combinations[digits.charAt(i) - '0'].toCharArray()){
            sb.append(c);
            dfs(i + 1, digits, combinations, result, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}

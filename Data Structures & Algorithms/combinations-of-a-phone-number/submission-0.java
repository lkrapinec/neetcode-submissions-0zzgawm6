class Solution {
    private static final Map<Character, List<Character>> map = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        
        StringBuilder sb = new StringBuilder();

        backtrack(0, digits, sb, result);

        return result;
    }

    private void backtrack(int start, String digits, StringBuilder sb, List<String> result){
        if(start >= digits.length()){
            result.add(sb.toString());
            return;
        }

        // for(int i = start; i < digits.length(); i++){
            for(char c : map.get(digits.charAt(start))){
                sb.append(c);
                backtrack(start + 1, digits, sb, result);
                sb.setLength(sb.length() - 1);
            }
        // }
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if(digits.length() == 0){
            return result;
        }

        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();

        backtrack(0, digits, sb, map, result);

        return result;
    }

    private void backtrack(int position, String digits, StringBuilder sb, Map<Character, char[]> map, List<String> result){
        if(position >= digits.length()){
            result.add(sb.toString());
            return;
        }

        char curr = digits.charAt(position);
        for(char c : map.get(curr)){
            sb.append(c);

            backtrack(position + 1, digits, sb, map, result);

            sb.setLength(sb.length() - 1);
        }
    }
}

//create map that will have key of number, and value as list of combinations
//for each number iterato through list and add value to combination
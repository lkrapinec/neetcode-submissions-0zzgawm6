class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = Map.of(
             ')', '(',
             '}', '{',
             ']', '[');
        Set<Character> openBrackets = Set.of('(','{','[');

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(openBrackets.contains(c)){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            if(map.get(c) != stack.pop()){
                return false;
            }
        }

        return stack.isEmpty();

    }
}

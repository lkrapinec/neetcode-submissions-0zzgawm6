class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        for(char c : s.toCharArray()){
            if(map.containsValue(c)){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }

            if(stack.peek() != map.get(c)){
                return false;
            }

            stack.pop();
        }
        return stack.isEmpty();
    }
}

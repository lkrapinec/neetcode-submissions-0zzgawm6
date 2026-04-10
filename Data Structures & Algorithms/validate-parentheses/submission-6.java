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

            if(stack.pop() != map.get(c)){
                return false;
            }
            
        }
        return stack.isEmpty();
    }
}

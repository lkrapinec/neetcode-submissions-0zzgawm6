class Solution {
    private static final Map<Character, Character> combination = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            Character openBracket = combination.get(c);

            if(openBracket == null){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty() || stack.pop() != openBracket){
                return false;
            }
        }

        return stack.isEmpty();
    }
}

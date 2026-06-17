class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']',  '[');

        for(char c : s.toCharArray()){
            Character opposite = pairs.get(c);

            //additional check if char is bracket
            if(opposite == null){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty() || stack.pop() != opposite){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

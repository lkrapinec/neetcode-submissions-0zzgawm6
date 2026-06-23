class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for(String token : tokens){
            if(!operators.contains(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }

            int first = stack.pop();
            int second = stack.pop();

            switch(token){
                case "+":
                    stack.push(second + first);
                    break;
                case "-":
                    stack.push(second - first);
                    break;
                case "*":
                    stack.push(second * first);
                    break;
                case "/":
                    stack.push(second / first);
                    break;
            }
        }
        return stack.pop();
    }
}

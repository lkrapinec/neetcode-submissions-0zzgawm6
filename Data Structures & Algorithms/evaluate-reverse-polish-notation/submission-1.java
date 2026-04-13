class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = Set.of("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(!operators.contains(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }
            //check if stack is empty
            Integer number1 = stack.pop();
            Integer number2 = stack.pop();

            Integer result;
            switch(token){
                case "+":
                    result = number2 + number1;
                    break;
                case "-":
                    result = number2 - number1;
                    break;
                case "*":
                    result = number2 * number1;
                    break;
                case  "/":
                    result = number2 / number1;
                    break;
                default:
                    throw new IllegalArgumentException();
                }

                stack.push(result);
        }
    Integer result = stack.pop();
    if(stack.isEmpty()){
        return result;
    }
    return -1;
    } 
}

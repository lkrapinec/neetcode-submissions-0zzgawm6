class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty()){
                stack.push(temperatures[i]);
                continue;
            }

            if(temperatures[i] <= stack.peek()){
                stack.push(temperatures[i]);
                continue;
            }



            int counter = 1;
            while(!stack.isEmpty() && temperatures[i] > stack.peek()){
                stack.pop();
                while(result[i - counter] != 0){
                    counter++;
                }
                result[i - counter] = counter;
            }
            stack.push(temperatures[i]);
        }
        return result;
    }
}
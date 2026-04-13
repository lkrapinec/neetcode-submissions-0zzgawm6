class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                Integer position = stack.pop();
                result[position] = i - position;
            }

            stack.push(i);
        }
        return result;
    }
}
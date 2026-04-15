class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();


        int maxVolume = 0;
        for(int i = 0; i < heights.length; i++){ 
            if(stack.isEmpty() || heights[i] > stack.peek()[0]){
                stack.push(new int[]{heights[i], i});
                continue;
            }
            if(!stack.isEmpty() && heights[i] == stack.peek()[0]){
                continue;
            }

            int index = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[0]){
                int[] top = stack.pop();
                index = top[1];
                int height = top[0];
                int volume = height * (i - index);
                maxVolume = Math.max(maxVolume, volume);  
            }
            stack.push(new int[]{heights[i], index});
            
        }
        while(!stack.isEmpty()){
                int[] top = stack.pop();
                int index = top[1];
                int height = top[0];
                int volume = height * (heights.length - index);
                maxVolume = Math.max(maxVolume, volume);
            }  

        return maxVolume;
    }
}




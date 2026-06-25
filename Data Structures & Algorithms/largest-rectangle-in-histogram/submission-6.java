class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> position = new Stack<>();
        Stack<Integer> distance = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (!position.isEmpty() && heights[i] == heights[position.peek()]) {
                continue;
            }

            int currDistance = i;
            while (!position.isEmpty() && heights[i] < heights[position.peek()]) {

                int height = heights[position.pop()];
                currDistance = distance.pop();
                int area = Math.max(heights[i] * (i -  currDistance + 1), height * (i -  currDistance));
                result = Math.max(area, result);
            }

            position.push(i);
            distance.push(currDistance);
        }
        while (!position.isEmpty()) {
            int height = position.pop();
            int currDistance = distance.pop();
            int area = heights[height] * (heights.length - currDistance);
            result = Math.max(area, result);
        }
        return result;
    }
}
// 7,1,7,2,2,4

// 7 0

// 1 0

// 7 1
// 1 0

// 2 2
// 1 0

// 4 5
// 2 1
// 1 0
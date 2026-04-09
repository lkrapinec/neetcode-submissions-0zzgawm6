class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int distance = right;
        int max = 0;
        while (left < right){
            int area = Math.min(heights[left], heights[right]) * distance;

            if(area > max){
                max = area;
            }

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
            distance--;
        }

        return max;
    }
}


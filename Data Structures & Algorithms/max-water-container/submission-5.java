class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int l = 0;
        int r = heights.length - 1;
        while(l < r){
            int vol = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(max, vol);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return max;
    }
}


//1,7,2,5,4,7,3,6
//start from first and last index
//take smaller index height and calculate volume (height * distance)
//move pointer with smaller val
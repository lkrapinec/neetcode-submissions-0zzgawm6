class Solution {
    public int trap(int[] height) {
        int left = 0;
        int maxLeft = height[left];

        int right = height.length - 1;
        int maxRight = height[right];

        int result = 0;
        while(left < right){
             if(height[left] < height[right]){
                if(height[left] < maxLeft){
                    result += maxLeft - height[left];
                }

                maxLeft = Math.max(maxLeft, height[left]);
                left++;
             }else{
                if(height[right] < maxRight){
                    result += maxRight - height[right];
                }

                maxRight = Math.max(maxRight, height[right]);
                right--;
             }
        }
        return result;
    }
}

//use left and right pointer, move smaller pointer
//memoeize max left height and right height
//if curr height less than max, then calculate diference and add to result
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }

        int[] maxMem = new int[length];
        int[] minMem = new int[length];
        maxMem[length - 1] = nums[length - 1];
        minMem[length - 1] = nums[length - 1];
        int result = nums[length - 1];


        for(int i = length - 2; i >= 0; i--){
            int curr = nums[i];

                maxMem[i] = Math.max(curr, curr * maxMem[i+1]);
                maxMem[i] = Math.max(maxMem[i], curr * minMem[i+1]);

                minMem[i] = Math.min(curr, curr * minMem[i+1]);
                minMem[i] = Math.min(minMem[i], curr * maxMem[i+1]);
           
            result = Math.max(maxMem[i], result);
            result = Math.max(minMem[i], result);
        }


        return result;
    }

}

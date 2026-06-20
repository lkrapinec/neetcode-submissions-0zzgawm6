class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int left, int right){
        int pivot = nums[right];
        int p = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        if(p == k){
            return pivot;
        }
        nums[right] = nums[p];
        nums[p] = pivot;
        if(p < k){
            return quickSelect(nums, k, p + 1, right);
        }
        return quickSelect(nums, k, left, p - 1); 
    }
}

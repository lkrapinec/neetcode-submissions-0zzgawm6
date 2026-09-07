class Solution {
    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int result = nums[0];

        for (int num : nums) {
            int prevMax = max;
            max = Math.max(num, num * max);
            max = Math.max(max, num * min);

            min = Math.min(num, num * min);
            min = Math.min(min, num * prevMax);

            result = Math.max(max, result);
            result = Math.max(min, result);
        }

        return result;
    }
}

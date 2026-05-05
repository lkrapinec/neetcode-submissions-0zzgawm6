class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int middle = (total + 1) / 2;

        int left = 0;
        int right = nums1.length;

        while(left <= right){
            int middle1 = left + (right - left) / 2;
            int middle2 = middle - middle1;

            int left1 = middle1 <= 0 ? Integer.MIN_VALUE : nums1[middle1 - 1];
            int right1 = middle1 >= nums1.length ? Integer.MAX_VALUE : nums1[middle1];

            int left2 = middle2 <= 0 ? Integer.MIN_VALUE : nums2[middle2 - 1];
            int right2 = middle2 >= nums2.length ? Integer.MAX_VALUE : nums2[middle2];

            if(left1 <= right2 && left2 <= right1){
                int leftMax = Math.max(left1, left2);
                if(total % 2 == 1){
                    return leftMax;
                }
                int rightMin = Math.min(right1, right2);

                return (leftMax + rightMin) / 2.0;
            }

            if(left1 > right2){
                right = middle1 - 1;
            }else{
                left = middle1 + 1;
            }
        }
        return -1;
    }
}

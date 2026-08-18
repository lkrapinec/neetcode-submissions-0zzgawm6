class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalLength = nums1.length + nums2.length;
        int half = (totalLength + 1) / 2;

        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int middle1 = left + (right - left) / 2;
            int middle2 = half - middle1;

            int left1 = middle1 > 0 ? nums1[middle1 - 1] : Integer.MIN_VALUE;
            int right1 = middle1 < nums1.length ? nums1[middle1] : Integer.MAX_VALUE;

            int left2 = middle2 > 0 ? nums2[middle2 - 1] : Integer.MIN_VALUE;
            int right2 = middle2 < nums2.length ? nums2[middle2] : Integer.MAX_VALUE;

            if(left1 > right2){
                right = middle1 - 1;
                continue;
            }

            if(left2 > right1){
                left = middle1 + 1;
                continue;
            }

            int firstMedian = Math.max(left1, left2);
            if(totalLength % 2 == 1){
                return firstMedian;
            }

            int secondMedian = Math.min(right1, right2);
            return (firstMedian + secondMedian) / 2.0;

        }
        return -1;
    }
}

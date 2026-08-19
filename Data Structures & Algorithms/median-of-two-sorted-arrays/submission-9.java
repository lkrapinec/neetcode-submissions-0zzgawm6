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
            int mid1 = left + (right - left) / 2;
            int mid2 = half - mid1;

            int left1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;

            int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 > right2){
                right = mid1 - 1;
                continue;
            }

            if(left2 > right1){
                left = mid1 + 1;
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
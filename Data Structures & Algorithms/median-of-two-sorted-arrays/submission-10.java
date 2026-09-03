class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);

        }

        int length = nums1.length + nums2.length;
        int half = (length + 1) / 2;

        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = half - mid1;

            int before1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int after1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;

            int before2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int after2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;

            if(before1 > after2){
                right = mid1 - 1;
                continue;
            }

            if(before2 > after1){
                left = mid1 + 1;
                continue;
            }

            int firstMedian = Math.max(before1, before2);
            if(length % 2 == 1){
                return firstMedian;
            }

            int secondMedian = Math.min(after1, after2);

            return (firstMedian + secondMedian + 0.0) / 2;
        }

        return -1;
    }
}

//nums1 = 3, nums2 = 1,2

//mid1 = 0, mid2 = 1

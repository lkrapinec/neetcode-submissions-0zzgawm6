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
        
        
        
        // int[] a = nums1;
        // int[] b = nums2;
        // int total = a.length + b.length;
        // int middleTotal = (total + 1) / 2;

        // if(b.length < a.length){
        //     int[] temp = a;
        //     a = b;
        //     b = temp;
        // }

        // int left = 0;
        // int right = a.length;

        // while (left <= right){
        //     int middleA = left + (right - left) / 2;
        //     int middleB = middleTotal - middleA;

        //     int leftA = middleA > 0 ? a[middleA - 1] : Integer.MIN_VALUE;
        //     int rightA = middleA < a.length ? a[middleA] : Integer.MAX_VALUE;

        //     int leftB = middleB > 0 ? b[middleB - 1] : Integer.MIN_VALUE;
        //     int rightB = middleB < b.length ? b[middleB] : Integer.MAX_VALUE;

        //     if(leftA <= rightB && leftB <= rightA){
        //         if(total % 2 != 0){
        //             return Math.max(leftA, leftB);
        //         }
        //         return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
        //     }

        //     if(leftA > rightB){
        //         right = middleA - 1;
        //     }else{
        //         left = middleA + 1;
        //     }
        // }
        // return -1;
    }
}

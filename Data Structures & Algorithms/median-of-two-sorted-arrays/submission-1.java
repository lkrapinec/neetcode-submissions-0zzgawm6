class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        int total = a.length + b.length;
        int middleTotal = (total + 1) / 2;

        if(b.length < a.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int left = 0;
        int right = a.length;

        while (left <= right){
            int middleA = left + (right - left) / 2;
            int middleB = middleTotal - middleA;

            int leftA = middleA > 0 ? a[middleA - 1] : Integer.MIN_VALUE;
            int rightA = middleA < a.length ? a[middleA] : Integer.MAX_VALUE;

            int leftB = middleB > 0 ? b[middleB - 1] : Integer.MIN_VALUE;
            int rightB = middleB < b.length ? b[middleB] : Integer.MAX_VALUE;

            if(leftA <= rightB && leftB <= rightA){
                if(total % 2 != 0){
                    return Math.max(leftA, leftB);
                }
                return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            }

            if(leftA > rightB){
                right = middleA - 1;
            }else{
                left = middleA + 1;
            }
        }
        return -1;
    }
}

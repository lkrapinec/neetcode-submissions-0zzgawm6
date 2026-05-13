class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int left = 0;
        int right = 0;

        int result[] = new int[nums.length - k + 1];

        while(right < nums.length){
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[right]){
                deque.removeLast();
            }
            deque.addLast(right);

            if(left > deque.getFirst()){
                deque.removeFirst();
            }

            if((right + 1) >= k){
                result[left] = nums[deque.getFirst()];
                left++;
            }
            right++;
        }
        return result;
    }
}
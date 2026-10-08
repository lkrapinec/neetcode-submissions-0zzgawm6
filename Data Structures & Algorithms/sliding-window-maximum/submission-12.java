class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);

        int length = nums.length;
        int[] result = new int[length - k + 1];

        for(int i = 0; i < length; i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.removeLast();
            }
         
            deque.addLast(i);
            
            if(i < k - 1){
                continue;
            }

            result[i - k + 1] = nums[deque.peekFirst()];

            if(deque.peekFirst() < i - k + 2){
                deque.removeFirst();
            }
        }

        return result;
    }
}

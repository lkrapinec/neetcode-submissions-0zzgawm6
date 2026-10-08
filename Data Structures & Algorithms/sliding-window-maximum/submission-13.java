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
            
            int resultPosition = i - k + 1;
            if(resultPosition < 0){
                continue;
            }

            result[resultPosition] = nums[deque.peekFirst()];

            if(deque.peekFirst() == resultPosition){
                deque.removeFirst();
            }
        }

        return result;
    }
}

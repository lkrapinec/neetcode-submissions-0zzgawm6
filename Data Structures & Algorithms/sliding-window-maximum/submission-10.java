class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offer(i);

            int resultPosition = i + 1 - k;
            if(resultPosition < 0){
                continue;
            }

            result[resultPosition] = nums[deque.peek()];
            if(resultPosition == deque.peek()){
                deque.pop();
            }
        }

        return result;
    }
}

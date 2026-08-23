class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int [nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
                  while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);

            if(i < k - 1){
                continue;
            }

            int left = i - k + 1;

            result[left] = nums[queue.peek()];

            if(left == queue.peek()){
                queue.poll();
            }
        }

        return result;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();

            int left = 0;
            int right = 0;

            int[] result = new int[nums.length - k + 1];
            while(right < nums.length){
                while(!deque.isEmpty() && nums[right] > deque.getLast()){
                    deque.removeLast();
                }
                deque.addLast(nums[right]);

                if(right + 1 >= k){
                    result[right - k + 1] = deque.getFirst();

                    if(!deque.isEmpty() && nums[right - k + 1] == deque.getFirst()){
                        deque.removeFirst();
                    }
                    left++;
                }
                right++;
            }
            return result;
    }
}
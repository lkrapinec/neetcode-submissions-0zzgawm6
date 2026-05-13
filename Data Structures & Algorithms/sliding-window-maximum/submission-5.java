class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();

            int right = 0;

            int[] result = new int[nums.length - k + 1];
            while(right < nums.length){
                while(!deque.isEmpty() && nums[right] > deque.getLast()){
                    deque.removeLast();
                }
                deque.addLast(nums[right]);

                if(right + 1 >= k){
                    int left = right - k + 1;
                    result[left] = deque.getFirst();

                    if(!deque.isEmpty() && nums[left] == deque.getFirst()){
                        deque.removeFirst();
                    }
                }
                right++;
            }
            return result;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();

            int left = 0;
            int right = 0;

            int[] result = new int[nums.length - k + 1];
            while(right < nums.length){
                //check if current element is bigger than max element in deque
                while(!deque.isEmpty() && nums[right] > nums[deque.getLast()]){
                    deque.removeLast();
                }
                deque.addLast(right);

                if(right + 1 >= k){
                    result[left] = nums[deque.getFirst()];

                    if(!deque.isEmpty() && nums[left] == nums[deque.getFirst()]){
                        deque.removeFirst();
                    }
                    left++;
                }
                right++;
            }
            return result;
    }
}
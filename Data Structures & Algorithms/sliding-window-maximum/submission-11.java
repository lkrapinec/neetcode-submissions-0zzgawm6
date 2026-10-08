class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

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


//if curr num is bigger than num on last position, then pop last position
//use stack

//if curr number is bigger than num on top of the stack, then pop stack until this is not true
//add curr num to stack
//start adding to result when right is bigger or equal to k
//if num on bottom of the stack is on the left side of the window, then remove it from the stack
//use deque to be able to append to start and the end
//store position instead of the value

//time O(n)
//space O(k)
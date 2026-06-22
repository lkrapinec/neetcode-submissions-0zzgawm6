class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char task : tasks){
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < count.length; i++){
            maxHeap.offer(count[i]);
        }

        int maxValue = maxHeap.poll();
        int counter = 0;
        while(!maxHeap.isEmpty() && maxHeap.peek() == maxValue){
            counter++;
            maxHeap.poll();
        }

        int time = (maxValue - 1) * n + counter + maxValue;
        return Math.max(time , tasks.length);
    }
}

//3A 1B 1C, n = 3
//A*3, B*0, C*0 = 9
//2X, 2Y, n = 2
//2*2, 2*2 
//find max letter, and multiply it with N, if there are multiple maxes, then add the rest

//A-B-NULL-A-B-NULL-A-B

//X-NULL-NULL-X-NULL-NULL-X-NULL-NULL-X
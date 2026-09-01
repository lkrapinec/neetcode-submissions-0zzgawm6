class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] numberOfChars = new int[26];

        for(char c : tasks){
            numberOfChars[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

        for(int i : numberOfChars){
            if(i > 0){
                maxHeap.offer(i);
            }
        }

        int maxRepeated = maxHeap.poll();

        int amountOfMaxRepeated = 1;
        while(!maxHeap.isEmpty() && maxRepeated == maxHeap.poll()){
            amountOfMaxRepeated++;
        }
        return Math.max((maxRepeated - 1) * (n + 1) + amountOfMaxRepeated, tasks.length);


    }
}


class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            priorityQueue.offer(stone);
        }

        while(priorityQueue.size() > 1){
            int stone1 = priorityQueue.poll();
            int stone2 = priorityQueue.poll();

            priorityQueue.offer(stone1 - stone2);
        }

        return priorityQueue.poll();
    }
}

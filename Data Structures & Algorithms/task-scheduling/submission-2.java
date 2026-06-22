class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countedLetters = new HashMap<>();
        for(char task : tasks){
            
            Integer count = countedLetters.get(task);
            if(count == null){
                countedLetters.put(task, 1);
            } else{
                countedLetters.put(task, ++count);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Map.Entry<Character, Integer> entry : countedLetters.entrySet()){
            maxHeap.offer(entry.getValue());
        }

        int maxValue = maxHeap.poll();
        int counter = 0;
        while(!maxHeap.isEmpty() && maxHeap.peek() == maxValue){
            counter++;
            maxHeap.poll();
        }

        return Math.max((maxValue - 1) * n + counter + maxValue, tasks.length);
    }
}

//3A 1B 1C, n = 3
//A*3, B*0, C*0 = 9
//2X, 2Y, n = 2
//2*2, 2*2 
//find max letter, and multiply it with N, if there are multiple maxes, then add the rest

//A-B-NULL-A-B-NULL-A-B

//X-NULL-NULL-X-NULL-NULL-X-NULL-NULL-X
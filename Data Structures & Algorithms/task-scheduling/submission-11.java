class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] numberOfChars = new int[26];

        for (char c : tasks) {
            numberOfChars[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i : numberOfChars) {
            if (i > 0) {
                maxHeap.offer(i);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        int counter = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            if (!maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                curr--;
                if (curr > 0) {
                    queue.offer(new int[] {curr, counter + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] <= counter) {
                maxHeap.offer(queue.poll()[0]);
            }

            counter++;
        }

        return counter;
    }
}

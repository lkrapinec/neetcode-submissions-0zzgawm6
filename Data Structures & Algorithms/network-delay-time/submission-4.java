class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], z -> new ArrayList<>())
                .add(new int[] {time[1], time[2]});
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[] minTimes = new int[n];
        for(int i = 0; i < n; i++){
            minTimes[i] = Integer.MAX_VALUE;
        }
        minTimes[k-1] = 0;

        minHeap.offer(new int[]{k, 0});
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int node = curr[0];
            int time = curr[1];

            if(visited.contains(node)){
                continue;
            }

            visited.add(node);

            List<int[]> neigbours = graph.get(node);
            if(neigbours == null){
                continue;
            }

            for(int[] nei : neigbours){
                if(nei[1] + time < minTimes[nei[0] - 1]){
                    minTimes[nei[0] - 1] = nei[1] + time;
                    minHeap.offer(new int[]{nei[0], nei[1] + time});
                }
                
            }
        }

        if(visited.size() != n){
            return -1;
        }

        int max = minTimes[0];
        for(int minTime : minTimes){
            max = Math.max(minTime, max);
        }

        return max;
    }
}
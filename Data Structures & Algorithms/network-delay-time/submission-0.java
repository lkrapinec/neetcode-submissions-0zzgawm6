class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();

        minHeap.add(new int[]{k - 1, 0});

        int result = 0;
        while(!minHeap.isEmpty()){
            int[] min = minHeap.poll();

            if(visited.contains(min[0])){
                continue;
            }
            
            int node = min[0];
            int dist = min[1];

            visited.add(node);
            result = dist;

            for(int[] child : adj.get(min[0])){
                if(visited.contains(child[0])){
                    continue;
                }

                int newDist = child[1] + dist;
                minHeap.offer(new int[]{child[0], newDist});
            }
        }
        return visited.size() == n ? result : -1;
    }
}

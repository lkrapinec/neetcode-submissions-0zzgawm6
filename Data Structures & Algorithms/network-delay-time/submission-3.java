class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] edge : times){
            int[] newEdge = new int[]{edge[1], edge[2]};
            edges.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(newEdge);
            // if(edge[0] == k){
            //     heap.offer(newEdge);
            // }
        }

        heap.offer(new int[]{k, 0});

        Set<Integer> visited = new HashSet<>();
        int result = 0;
        while(!heap.isEmpty()){
            int[] curr = heap.poll();

            if(visited.contains(curr[0])){
                continue;
            }

            visited.add(curr[0]);
            result = curr[1];

            List<int[]> edge = edges.get(curr[0]);
            if(edge == null){
                continue;
            }

            for(int[] next : edge){
                if(!visited.contains(next[0])){
                    heap.offer(new int[]{next[0], next[1] + curr[1]});
                }
            }
        }

        return visited.size() == n ? result : -1;

    }
}

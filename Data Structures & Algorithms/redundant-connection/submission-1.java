class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = edges.length;
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegrees = new int[n + 1];
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;

            adj.get(edge[1]).add(edge[0]);
            indegrees[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            if(indegrees[i] == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            indegrees[curr]--;
            
            for(int neighbour : adj.get(curr)){
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 1){
                    queue.offer(neighbour);
                }
            }
        }

        for(int i = edges.length - 1; i >= 0; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if(indegrees[u] > 0 && indegrees[v] > 0){
                return new int[]{u,v};
            }
        }

        return new int[0];
    }
}

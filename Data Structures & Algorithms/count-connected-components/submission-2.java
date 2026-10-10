class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int result = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                walk(i, adj, visited);
                result++;
            }
        }

        return result;
    }

    private void walk(int curr, List<List<Integer>> adj, boolean[] visited){
        if(visited[curr]){
            return;
        }

        visited[curr] = true;
        for(int next : adj.get(curr)){
            walk(next, adj, visited);
        }
        
    }
}

//have visited array
//if curr node is not in visited, then this is a new component
//for each node go through all connected nodes and mark them as visited
//create adjancency list
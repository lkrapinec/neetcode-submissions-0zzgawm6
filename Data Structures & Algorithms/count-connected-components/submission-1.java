class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, graph);
                result++;
            }
        }

        return result;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        if(visited[node]){
            return;
        }

        visited[node] = true;

        for(int edge : graph.get(node)){
            if(!visited[edge]){
                dfs(edge, visited, graph);
            }
        }
    }
}
//pick one node and go through all connected nodes
//mark those nodes as visited
//find next unvisited node and do the same
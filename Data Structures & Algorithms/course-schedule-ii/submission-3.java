class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        List<Integer> output = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                dfs(i, indegree, adj, output);
            }
        }

        if(output.size() != numCourses){
            return new int[0];
        }

        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = output.get(i);
        }

        return res;

    }

    private void dfs(int node, int[] indegree, List<List<Integer>> adj, List<Integer> output){
        output.add(node);
        indegree[node]--;
        for(int curr : adj.get(node)){
            indegree[curr]--;
            if(indegree[curr] == 0){
                dfs(curr, indegree, adj, output);
            }
        }
    }
}

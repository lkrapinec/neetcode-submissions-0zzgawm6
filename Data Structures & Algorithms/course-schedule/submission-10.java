class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses];
        for (int node = 0; node < numCourses; node++) {
            if (hasCycle(node, visited, adj)) {
                return false;
            }

            
            
        }

        return true;
    }

    private boolean hasCycle(int node, int[] visited, List<List<Integer>> adj) {
        if (visited[node] == 2) {
            return false;
        }

        if(visited[node] == 1){
            return true;
        }

        visited[node] = 1;

        for (int neigbour : adj.get(node)) {
            if (hasCycle(neigbour, visited, adj)) {
                return true;
            }
        }

        visited[node] = 2;
        return false;
    }
}

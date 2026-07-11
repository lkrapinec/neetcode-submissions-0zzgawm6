class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0){
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] passed = new boolean[n];

            if (isCycle(0, -1, passed, graph)) {
                return false;
            }

        for (boolean v : passed) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean isCycle(
        int node, int prev, boolean[] passed, Map<Integer, List<Integer>> graph) {
        if (passed[node]) {
            return true;
        }

        passed[node] = true;

        List<Integer> prerequisites = graph.get(node);
        if (prerequisites == null) {
            return true;
        }
        for (int next : prerequisites) {
            if (next == prev) {
                continue;
            }
            if (isCycle(next, node, passed, graph)) {
                return true;
            }
        }

        return false;
    }
}

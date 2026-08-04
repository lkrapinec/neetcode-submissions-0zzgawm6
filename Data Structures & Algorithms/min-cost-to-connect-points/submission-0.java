class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int[] dist = new int[length];
        boolean[] visit = new boolean[length];
        for (int i = 0; i < length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        int node = 0;
        int edges = 0;
        int result = 0;

        while (edges < length - 1) {
            visit[node] = true;
            int nextNode = -1;

            for (int i = 0; i < length; i++) {
                if (visit[i]) {
                    continue;
                }

                int currDist = Math.abs(points[i][0] - points[node][0])
                    + Math.abs(points[i][1] - points[node][1]);

                dist[i] = Math.min(dist[i], currDist);
                if(nextNode == -1 || dist[i] < dist[nextNode]){
                    nextNode = i;
                }

                
            }
            result += dist[nextNode];
                node = nextNode;
                edges++;
            
        }
        return result;
    }
}

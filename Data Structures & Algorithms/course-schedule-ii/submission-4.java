class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int finish = 0;
        int[] output = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            output[numCourses - 1 - finish] = node;
            finish++;

            for(int pre : adj.get(node)){
                indegree[pre]--;
                if(indegree[pre] == 0){
                    q.add(pre);
                }
            }
        }

        if(finish != numCourses){
            return new int[0];
        }
        return output;
    }
}

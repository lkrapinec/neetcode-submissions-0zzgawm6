class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int position = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            result[position] = curr;
            position++;

            for(int nei : adj.get(curr)){
                indegrees[nei]--;
                if(indegrees[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        if(position < numCourses){
            return new int[]{};
        }

        return result;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
            indegrees[prerequisite[1]]++;
        }

        
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int finish = queue.size();
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int nei : adj.get(curr)) {
                    indegrees[nei]--;

                    if (indegrees[nei] == 0) {
                        queue.offer(nei);
                        finish++;
                    }
            }
        }
        return finish == numCourses;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            indegrees[i] = adj.get(i).size();
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int finish = queue.size();
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < numCourses; i++) {
                if (adj.get(i).contains(curr)) {
                    indegrees[i]--;

                    if (indegrees[i] == 0) {
                        queue.offer(i);
                        finish++;
                    }
                }
            }
        }
        return finish == numCourses;
    }
}

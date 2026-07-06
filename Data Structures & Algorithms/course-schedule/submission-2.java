class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[0], k -> new ArrayList<>())
                .add(prerequisite[1]);
        }

        //0 - not visited, 1 - visited, 2 - can be completed
        int[] state = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!canBeCompleted(i, graph, state)){
                return false;
            }
        }

        return true;
    }

    private boolean canBeCompleted(int course, Map<Integer, List<Integer>> graph, int[] state){
        if(state[course] == 1){
            return false;
        }

        if(state[course] == 2){
            return true;
        }

        List<Integer> prerequisites = graph.get(course);
        if(prerequisites == null){
            return true;
        }

        state[course] = 1;

        for(int prerequisite : prerequisites){
            if(!canBeCompleted(prerequisite, graph, state)){
                return false;
            }
        }

         state[course] = 2;
         return true;
    }

   

}
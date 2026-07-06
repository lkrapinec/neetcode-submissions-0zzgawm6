class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseConnections = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            courseConnections.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>())
                .add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!canBeCompleted(i, courseConnections, new HashSet<>())){
                return false;
            }
        }

        return true;
    }

    private boolean canBeCompleted(int course, Map<Integer, List<Integer>> courseConnections, Set<Integer> visited){
        if(visited.contains(course)){
            return false;
        }

        visited.add(course);
        List<Integer> connections = courseConnections.get(course);

        if(connections == null || connections.isEmpty()){
            visited.remove(course);
            return true;
        }

        for(int connection : connections){
            if(!canBeCompleted(connection, courseConnections, visited)){
                visited.remove(course);
                return false;
            }
        }
        courseConnections.put(course, new ArrayList<>());
        visited.remove(course);
        return true;
    }

}
// find courses with no prerequisites
// store are courses with prerequisites
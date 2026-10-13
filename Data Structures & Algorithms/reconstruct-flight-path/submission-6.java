class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> result = new ArrayList<>();

        dfs("JFK", adj, result);

        Collections.reverse(result);

        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adj, List<String> result){
        PriorityQueue<String> neighbours = adj.get(airport);
        while(neighbours != null && !neighbours.isEmpty()){
            String neigbour = neighbours.poll();
            dfs(neigbour, adj, result);
        }

        result.add(airport);
    }
}

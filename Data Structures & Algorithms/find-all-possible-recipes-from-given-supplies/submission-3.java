class Solution {
    public List<String> findAllRecipes(
        String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<Integer>> usedBy = new HashMap<>();
        int[] indegree = new int[recipes.length];
        for (int i = 0; i < recipes.length; i++) {
            indegree[i] = ingredients.get(i).size();
            for (String ing : ingredients.get(i)) {
                usedBy.computeIfAbsent(ing, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<String> queue = new ArrayDeque<>(Arrays.asList(supplies)); // supplies are the sources
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (int i : usedBy.getOrDefault(cur, List.of())) {
                if (--indegree[i] == 0) {
                    result.add(recipes[i]);
                    queue.offer(recipes[i]);
                }
            }
        }
        return result;
    }
}

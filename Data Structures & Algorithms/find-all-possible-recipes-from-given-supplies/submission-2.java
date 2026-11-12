class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        Queue<String> queue = new ArrayDeque<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];

            indegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(
                    ingredient, k -> new ArrayList<>()
                ).add(recipe);
            }
        }

        // Initially available supplies
        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();

        // Topological sort
        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (indegree.containsKey(curr)) {
                result.add(curr);
            }

            for (String recipe : graph.getOrDefault(
                curr, Collections.emptyList()
            )) {
                indegree.put(recipe, indegree.get(recipe) - 1);

                if (indegree.get(recipe) == 0) {
                    queue.offer(recipe);
                }
            }
        }

        return result;
    

    }
}

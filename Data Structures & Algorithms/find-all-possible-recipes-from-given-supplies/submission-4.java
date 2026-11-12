class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<Integer>> usedBy = new HashMap<>();
        int[] indegree = new int[recipes.length];

        for(int i = 0; i < recipes.length; i++){
            indegree[i] = ingredients.get(i).size();

            for(String ing : ingredients.get(i)){
                usedBy.computeIfAbsent(ing, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        for(String supply : supplies){
            queue.offer(supply);
        }

        while(!queue.isEmpty()){
            String curr = queue.poll();


            List<Integer> rec = usedBy.get(curr);
            if(rec == null){
                continue;
            }
            for(Integer i : rec){
                indegree[i]--;

                if(indegree[i] == 0){
                    result.add(recipes[i]);
                    queue.offer(recipes[i]);
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Queue<String> queue = new ArrayDeque<>();

        int[] indegrees = new int[recipes.length];
        for(int i = 0; i < ingredients.size(); i++){
            List<String> ingredient = ingredients.get(i);
            indegrees[i] = ingredient.size();

            for(String supply : supplies){
                if(ingredient.contains(supply)){
                    indegrees[i]--;
                    if(indegrees[i] == 0){
                        queue.offer(recipes[i]);
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();

        while(!queue.isEmpty()){
            String curr = queue.poll();;

            result.add(curr);

            for(int i = 0; i < ingredients.size(); i++){
                if(ingredients.get(i).contains(curr)){
                    indegrees[i]--;
                    if(indegrees[i] == 0){
                        queue.offer(recipes[i]);
                    }
                }
            }
        }

        return result;


    }
}

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();

        Set<String> suppliesSet = new HashSet<>();
        for(String supplie : supplies){
            suppliesSet.add(supplie);
        }

        Map<String, List<String>> recipeAndIngredients = new HashMap<>();
        for(int i = 0; i < recipes.length; i++){
            recipeAndIngredients.put(recipes[i], ingredients.get(i));
        }

        Set<String> passed = new HashSet<>();

        for(int i = 0; i < recipes.length; i++){
            checkRecipe(recipes[i], recipeAndIngredients, suppliesSet, result, passed);
        }

        return result;
    }

    private boolean checkRecipe(String curr, Map<String, List<String>> recipeAndIngredients, Set<String> supplies, List<String> result, Set<String> passed){
        if(result.contains(curr)){
            return true;
        }

        if(passed.contains(curr)){
            return false;
        }

        List<String> ing = recipeAndIngredients.get(curr); 
        if(ing == null){
            return false;
        }


        passed.add(curr);

        boolean canBeMade = true;


        for(String ingredient : ing){
            if(supplies.contains(ingredient)){
                continue;
            }
            if(result.contains(ingredient)){
                continue;
            }

            if(!checkRecipe(ingredient,recipeAndIngredients, supplies, result, passed)){
                canBeMade = false;
                break;
            }
        }

        passed.remove(curr);
        if(canBeMade){
            result.add(curr);
        }

        return canBeMade;

    }
}




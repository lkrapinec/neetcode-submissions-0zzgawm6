class Solution {
    public int minDistance(String word1, String word2) {
        int[][] mem = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < mem.length; i++){
            for(int j = 0; j < mem[0].length; j++){
                mem[i][j] = -1;
            }
        }
        return dfs(0,0,word1,word2, mem);
    }

    private int dfs(int position1, int position2, String word1, String word2, int[][] mem){
        // if(position1 >= word1.length() && position2 >= word2.length()){
        //     return 0;
        // }

        if(mem[position1][position2] != -1){
            return mem[position1][position2];
        }

        if(position1 >= word1.length()){
            return word2.length() - position2;
        }

        if(position2 >= word2.length()){
            return word1.length() - position1;
        }

        if(word1.charAt(position1) == word2.charAt(position2)){
            mem[position1][position2] = dfs(position1 + 1, position2 + 1, word1, word2, mem);
            return mem[position1][position2];
        }

        int insert = dfs(position1, position2 + 1, word1, word2, mem);
        int delete = dfs(position1 + 1, position2, word1, word2, mem);
        int replace = dfs(position1 + 1, position2 + 1, word1, word2, mem);

        int min = Math.min(insert, delete);
        min = Math.min(min, replace);

        mem[position1][position2] = min + 1;

        return mem[position1][position2];
    }
}

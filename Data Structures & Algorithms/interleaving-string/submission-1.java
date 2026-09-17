class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }

        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0){
            return true;
        }

        if(s1.length() == 0){
            return s2.equals(s3);
        }

        if(s2.length() == 0){
            return s1.equals(s3);
        }

        int[][] mem1 = new int [s1.length()][s3.length()];
        int[][] mem2 = new int [s2.length()][s3.length()];

        
        for(int j = 0; j < s3.length(); j++){
               for(int i = 0; i < s1.length(); i++){
                    mem1[i][j] = -1;
                } 
                for(int i = 0; i < s2.length(); i++){
                    mem2[i][j] = -1;
                } 
        }

        return dfs(0,0,0, s1,s2,s3, mem1, mem2) == 1;
    }

    private int dfs(int index1, int index2, int index3, String s1, String s2, String s3, int[][] mem1, int[][] mem2){
        if(index3 == s3.length()){
            return index1 == s1.length() && index2 == s2.length() ? 1 : 0;
        }

        // if(index1 >= s1.length() || index2 >= s2.length()){
        //     return 0;
        // }
        if(index1 < s1.length()){
             if(mem1[index1][index3] != -1){
                return mem1[index1][index3];
            }
        }
        if(index2 < s2.length()){
            if(mem2[index2][index3] != -1){
                return mem2[index2][index3];
            }
        }
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
                mem1[index1][index3] = dfs(index1 + 1, index2, index3 + 1, s1, s2, s3, mem1, mem2);
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
                mem2[index2][index3] = dfs(index1, index2 + 1, index3 + 1, s1, s2, s3, mem1, mem2);
        }

        if(index1 < s1.length() && mem1[index1][index3] == 1|| index2 < s2.length() && mem2[index2][index3] == 1){
            return 1;
        }

        return 0;
        
    }
}

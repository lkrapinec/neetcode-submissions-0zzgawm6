class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        int[][] mem = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                mem[i][j] = -1;
            }
        }

        return dfs(0, 0, s1, s2, s3, mem) == 1;
    }

    private int dfs(int index1, int index2, String s1, String s2, String s3, int[][] mem) {
        int index3 = index1 + index2;
        if (index3 == s3.length()) {
            return index1 == s1.length() && index2 == s2.length() ? 1 : 0;
        }


        if (mem[index1][index2] != -1) {
            return mem[index1][index2];
        }

        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            mem[index1][index2] = dfs(index1 + 1, index2, s1, s2, s3, mem);

            if(mem[index1][index2] == 1){
                return mem[index1][index2];
            }
        }

        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            mem[index1][index2] = dfs(index1, index2 + 1, s1, s2, s3, mem);

             if(mem[index1][index2] == 1){
                return mem[index1][index2];
            }
        }
        return 0;
    }
}

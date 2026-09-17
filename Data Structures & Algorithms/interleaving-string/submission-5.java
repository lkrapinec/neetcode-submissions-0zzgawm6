class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }

        Boolean[][] mem = new Boolean[s1.length() + 1][s2.length() + 1];

        return dfs(0, 0, s1, s2, s3, mem);
    }

    private boolean dfs(int index1, int index2, String s1, String s2, String s3, Boolean[][] mem) {
        if (index1 == s1.length() && index2 == s2.length()) {
            return true;
        }


        if (mem[index1][index2] != null) {
            return mem[index1][index2];
        }

        int index3 = index1 + index2;
        boolean result = false;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            result = dfs(index1 + 1, index2, s1, s2, s3, mem);
        }

        if (!result && index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            result = dfs(index1, index2 + 1, s1, s2, s3, mem);

        }

        mem[index1][index2] = result;
        return mem[index1][index2];
    }
}

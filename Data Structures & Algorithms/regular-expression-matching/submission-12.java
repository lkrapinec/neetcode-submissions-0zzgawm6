class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] mem = new Boolean[s.length() + 1][p.length() + 1];

        // return dfs(0, 0, s, p, mem);

        for (int stringPosition = s.length(); stringPosition >= 0; stringPosition--) {
            for (int patternPosition = p.length(); patternPosition >= 0; patternPosition--) {
                if (patternPosition == p.length()) {
                    mem[stringPosition][patternPosition] =
                        stringPosition == s.length() && patternPosition == p.length();
                    continue;
                }

                boolean firstMatch = stringPosition < s.length()
                    && (p.charAt(patternPosition) == s.charAt(stringPosition)
                        || p.charAt(patternPosition) == '.');

                if (patternPosition + 1 < p.length() && p.charAt(patternPosition + 1) == '*') {
                    mem[stringPosition][patternPosition] =
                         mem[stringPosition][patternPosition + 2]
                        || (firstMatch &&  mem[stringPosition + 1][patternPosition]);
                }

                else {
                    mem[stringPosition][patternPosition] =
                        firstMatch &&  mem[stringPosition + 1][patternPosition + 1];
                }
            }
        }

        return mem[0][0];
    }
}
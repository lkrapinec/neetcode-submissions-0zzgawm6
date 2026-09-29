class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] mem = new boolean[s.length() + 1][p.length() + 1];
        mem[s.length()][p.length()] = true;

        for (int stringPosition = s.length(); stringPosition >= 0; stringPosition--) {
            for (int patternPosition = p.length() - 1; patternPosition >= 0; patternPosition--) {
                boolean firstMatch = stringPosition < s.length()
                    && (p.charAt(patternPosition) == s.charAt(stringPosition)
                        || p.charAt(patternPosition) == '.');

                if (patternPosition + 1 < p.length() && p.charAt(patternPosition + 1) == '*') {
                    mem[stringPosition][patternPosition] =
                         mem[stringPosition][patternPosition + 2]
                        || (firstMatch &&  mem[stringPosition + 1][patternPosition]);
                }

                else if(firstMatch){
                    mem[stringPosition][patternPosition] = mem[stringPosition + 1][patternPosition + 1];
                }
            }
        }

        return mem[0][0];
    }
}
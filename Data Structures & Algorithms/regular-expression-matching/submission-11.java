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
                        dfs(stringPosition, patternPosition + 2, s, p, mem)
                        || (firstMatch && dfs(stringPosition + 1, patternPosition, s, p, mem));
                }

                else {
                    mem[stringPosition][patternPosition] =
                        firstMatch && dfs(stringPosition + 1, patternPosition + 1, s, p, mem);
                }
            }
        }

        return mem[0][0];
    }

    private boolean dfs(
        int stringPosition, int patternPosition, String s, String p, Boolean[][] mem) {
        if (patternPosition == p.length()) {
            return stringPosition == s.length() && patternPosition == p.length();
        }

        if (mem[stringPosition][patternPosition] != null) {
            return mem[stringPosition][patternPosition];
        }

        boolean firstMatch = stringPosition < s.length()
            && (p.charAt(patternPosition) == s.charAt(stringPosition)
                || p.charAt(patternPosition) == '.');

        if (patternPosition + 1 < p.length() && p.charAt(patternPosition + 1) == '*') {
            mem[stringPosition][patternPosition] =
                dfs(stringPosition, patternPosition + 2, s, p, mem)
                || (firstMatch && dfs(stringPosition + 1, patternPosition, s, p, mem));
        }

        else {
            mem[stringPosition][patternPosition] =
                firstMatch && dfs(stringPosition + 1, patternPosition + 1, s, p, mem);
        }
        return mem[stringPosition][patternPosition];
    }
}
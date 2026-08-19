class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] letters = new int[52];
        for (char c : t.toCharArray()) {
            int position = charToPosition(c);
            letters[position]++;
        }

        int[] presentLetters = new int[64];
        int presentAmount = 0;

        int left = 0;
        int resultLeft = -1;
        int resultRight = s.length() - 1;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            int position = charToPosition(curr);

            if (letters[position] == 0) {
                continue;
            }

            presentLetters[position]++;
            if (presentLetters[position] > letters[position]) {
                continue;
            }

            presentAmount++;

            if (presentAmount < t.length()) {
                continue;
            }

            while (presentAmount == t.length()) {
                if (right - left < resultRight - resultLeft) {
                    resultLeft = left;
                    resultRight = right;
                }

                char leftChar = s.charAt(left);
                int leftPosition = charToPosition(leftChar);
                left++;

                if (letters[leftPosition] == 0) {
                    continue;
                }

                presentLetters[leftPosition]--;
                if (presentLetters[leftPosition] < letters[leftPosition]) {
                    presentAmount--;
                }
            }
        }

        if (resultLeft == -1) {
            return "";
        }

        return s.substring(resultLeft, resultRight + 1);
    }

    private int charToPosition(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        return c - 'a' + ('Z' - 'A') + 1;
    }
}

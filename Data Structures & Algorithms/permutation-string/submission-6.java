class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int lenght1 = s1.length();
        int length2 = s2.length();

        if (lenght1 > length2) {
            return false;
        }

        int[] expectedChars = new int[26];
        for (char c : s1.toCharArray()) {
            expectedChars[c - 'a']++;
        }

        int[] foundChars = new int[26];
        int sameChars = 0;

        int left = 0;
        for (int right = 0; right < length2; right++) {
            char curr = s2.charAt(right);

            if (expectedChars[curr - 'a'] > 0) {
                foundChars[curr - 'a']++;
                if (expectedChars[curr - 'a'] >= foundChars[curr - 'a']) {
                    sameChars++;
                }
            }

            if (right - left + 1 < lenght1) {
                continue;
            }

            if (sameChars == lenght1) {
                return true;
            }

            char leftChar = s2.charAt(left);

            if (expectedChars[leftChar - 'a'] > 0) {
                foundChars[leftChar - 'a']--;

                if (expectedChars[leftChar - 'a'] > foundChars[leftChar - 'a']) {
                    sameChars--;
                }
            }
            left++;
        }

        return false;
    }
}

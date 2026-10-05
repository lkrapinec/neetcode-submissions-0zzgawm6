class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> combination = new ArrayList<>();

        createSubstrings(0, s, combination, result);

        return result;
    }

    private void createSubstrings(
        int left, String s, List<String> combination, List<List<String>> result) {
        if (left >= s.length()) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int right = left; right < s.length(); right++) {
            if (isPalidrome(left, right, s)) {
                combination.add(s.substring(left, right + 1));
                createSubstrings(right + 1, s, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }

    private boolean isPalidrome(int left, int right, String s) {
        if (left > right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalidrome(left + 1, right - 1, s);
    }
}
// go from left to right, for each char try to create a palidrome by expanding to left and right
// if left and right are different, then string is not a palidrome

// exapmle: aaab
//          0123
// 0 -> cannot be expanded
// 1 a -> aaa -> _aaab X
// what about aa -> start expanding from curr position

// to check a palindrome, we have 2 options -> expand from char to the left and expand from curr
// char

// what are all the different ways to try to create a list of substrings
// define max size of a palidrome
// max = s length = 3
//[aab] X
// max = 2
//[aa, b], [a, ab] -> how to achieve this
// max = 1
//[a, a, b]

// max = 2, s = aaaa
//[a aa a], [aa, aa], [aa, a, a], [a, a, aa]

// first build string to max, then increase char position and build that to max
// a X
// aa

class Solution {
    private static final char LEFT = '(';
    private static final char RIGHT = ')';
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append(LEFT);
            backtrack(left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0 && left < right) {
            sb.append(RIGHT);
            backtrack(left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

//()

// 2x (, 2x)
//(())
//()()
// 2 left + 2 right, left right, left right

// there must always be more left brackets

//                      (
//          ()                               ((
//      ()(         ()) -> this is invalid.     ((( (()
//  ()((   ()()

// you have two options add left bracket or add right bracket(if there are already more left
// brackets) return when there are exactly n left and right brackets
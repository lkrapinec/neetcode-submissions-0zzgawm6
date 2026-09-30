class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(n, n, sb, result);

        return result;
    }

    private void backtrack(int remainingOpen, int remainingClosed, StringBuilder sb, List<String> result){
        if(remainingOpen == 0 && remainingClosed == 0){
            result.add(sb.toString());
            return;
        }

        if(remainingOpen > 0){
            sb.append('(');
            backtrack(remainingOpen - 1, remainingClosed, sb, result);
            sb.setLength(sb.length() - 1);
        }

        if(remainingOpen < remainingClosed){
            sb.append(')');
            backtrack(remainingOpen, remainingClosed - 1, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }
}

//3,3
//backtrack(2,3, [(])

//2,3
//backtrack(1,3, [((])
//backtrack(2,2, [()])

//1,3
//backtrack(0,3, [(((])
//backtrack(1,2, [(()])

//0,3
//backtrack(0,2, [((()])

//0,2
//backtrack(0,1, [((())])

//0,1
//backtrack(0,0, [((()))])

//0,0
//add result


//you can add up to n open brackets
//you always need more open brackets than closed to add a new closed one, otherwise you can add only open bracket

//count curr open and closed brackets
//if there are more or equal closed brackets add open bracket 
//otherwise add open and closed brackets -> branch to two solutions
//always check if open brackets reached the limit

//we can use recursion to do that



//(
//(), ((
//()(, (((, (()
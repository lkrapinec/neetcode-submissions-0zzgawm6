class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> part = new ArrayList<>();

        backtrack(0, s, part, result);
        return result;
    }

    private void backtrack(int start, String s,List<String> part, List<List<String>> result){
        if(start >= s.length()){
            result.add(new ArrayList<>(part));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalidrome(s, start, i)){
                part.add(s.substring(start, i + 1));
                backtrack(i + 1, s, part, result);
                part.remove(part.size() - 1);
            }
        }
    }




    private boolean isPalidrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}

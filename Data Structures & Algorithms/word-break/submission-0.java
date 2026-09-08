class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] isWord = new boolean[length + 1];
        isWord[length] = true;

        for(int i = length; i >= 0; i--){
            for(String word : wordDict){
                int currLength = word.length();
                if(i +  currLength > length){
                    continue;
                }

                if(isWord[i+ currLength] && s.substring(i, i + currLength).equals(word)){
                    isWord[i] = true;
                }
            }
        }
        return isWord[0];
    }
}

//applepenapple, ["apple","pen","ape"]

//take word in dictionary and check if word start with it

//go from end to front
//memoize length of new word
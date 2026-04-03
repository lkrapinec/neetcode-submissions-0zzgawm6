class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mappedAnagrams = new HashMap<>();

        for(String word : strs){
            String sortedWord = sortWord(word);

            List<String> anagrams;
            if(mappedAnagrams.containsKey(sortedWord)){
                anagrams = mappedAnagrams.get(sortedWord);
            } else{
                anagrams = new ArrayList<>();
            }
                anagrams.add(word);

                mappedAnagrams.put(sortedWord, anagrams);
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> value : mappedAnagrams.values()){
            result.add(value);
        }

        return result;
    }


    public String sortWord(String word){
        char[] chars =  word.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupedAnagrams = new HashMap<>();

        for(String str : strs){
            String key = generateKey(str);


        //      List<String> value = groupedAnagrams.get(key);

        //      if(value == null){
        //         value = new ArrayList<>();
        //      }

        //     value.add(str);
        //      groupedAnagrams.put(key, value);
        groupedAnagrams.computeIfAbsent(key, k -> new ArrayList<>())
                        .add(str);

        }

        return new ArrayList<>(groupedAnagrams.values());
    }

    private String generateKey(String str){
        int[] counter = new int[26];

        for(char c : str.toCharArray()){
            counter[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < counter.length; i++){
            if(counter[i] != 0){
                char c = (char) (i + 'a');
                sb.append(counter[i]).append(c);
            }
        }

        return sb.toString();
    }
}

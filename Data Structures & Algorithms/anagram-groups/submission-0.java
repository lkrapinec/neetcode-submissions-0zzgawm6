class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupedAnagrams = new HashMap<>();

        for(String s: strs){
            char[] chars = s.toCharArray();
            
            int[] keyChars = new int[26];
            for(char c : chars){
                keyChars['z'- c]++;
            }

            String key = Arrays.toString(keyChars);
            if(!groupedAnagrams.containsKey(key)){
                groupedAnagrams.put(key, new ArrayList<String>());
            }
            groupedAnagrams.get(key).add(s);
        }

        return new ArrayList<>(groupedAnagrams.values());
        }
    }


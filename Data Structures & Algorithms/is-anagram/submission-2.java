class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> characters = new HashMap<>();

        for(char c : s.toCharArray()){
            if(!characters.containsKey(c)){
                characters.put(c, 1);
            }else{
                characters.put(c, characters.get(c) + 1);

            }
        }

        for(char c : t.toCharArray()){
            if(!characters.containsKey(c)){
                return false;
            }
            Integer value = characters.get(c) -1;
            if(value < 0){
                return false;
            }

            if(value == 0){
                characters.remove(c);
            }else{
                characters.put(c, value);

            }

        }


        return characters.size() == 0;
    }
}

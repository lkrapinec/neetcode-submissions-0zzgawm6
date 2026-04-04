class Solution {
    private static final char separator = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            int size = word.toCharArray().length;
            sb.append(size);
            sb.append(separator);
            sb.append(word);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> strs = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            while(str.charAt(i) != separator){
                sb.append(str.charAt(i));
                i++;
            }
            int wordSize = Integer.parseInt(sb.toString());
            
            sb = new StringBuilder();
            for(int j = 1; j <= wordSize; j++){
                sb.append(str.charAt(i+j));
            }
            strs.add(sb.toString());
            sb = new StringBuilder();
            i += wordSize;
        }

        return strs;
    }
}

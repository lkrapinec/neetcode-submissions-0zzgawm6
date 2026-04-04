class Solution {
    private static final char SEPARATOR = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            int size = word.length();
            sb.append(size);
            sb.append(SEPARATOR);
            sb.append(word);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> strs = new ArrayList<>();

        for(int i = 0; i < str.length();){

            int sepPosition = str.indexOf(SEPARATOR, i);
            int wordSize = Integer.parseInt(str.substring(i, sepPosition));

            int start = sepPosition + 1;
            int end = start + wordSize;

            // while(str.charAt(i) != SEPARATOR){
            //     sb.append(str.charAt(i));
            //     i++;
            // }
            // int wordSize = Integer.parseInt(sb.toString());
            
            // sb = new StringBuilder();
            // for(int j = 1; j <= wordSize; j++){
            //     sb.append(str.charAt(i+j));
            // }
            // strs.add(sb.toString());
            // sb = new StringBuilder();
            // i += wordSize;

            strs.add(str.substring(sepPosition+1,sepPosition+1+wordSize));
            i = end;
        }

        return strs;
    }
}

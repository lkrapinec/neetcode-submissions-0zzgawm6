class Solution {
    char delimiter = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String text : strs){
            sb.append(text.length());
            sb.append(delimiter);
            sb.append(text);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c <= '9' && c >= '0' && counter == 0){
                sb.append(c);
            }else if((c< '0' || c > '9') && counter == 0) {
                counter = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                if(counter == 0){
                    strs.add("");
                }
            }else{
                sb.append(c);
                counter--;

                if(counter == 0){
                    strs.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return strs;
    }
}

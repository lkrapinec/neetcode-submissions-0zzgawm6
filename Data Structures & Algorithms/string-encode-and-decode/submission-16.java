class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length())
            .append("#")
            .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int start = 0;

        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '#'){
                continue;
            }


            int length = Integer.parseInt(str.substring(start,i));
            start = length + 1 + i;
            result.add(str.substring(i+1, start));
            i = start;
            
        }

        return result;
    }
}
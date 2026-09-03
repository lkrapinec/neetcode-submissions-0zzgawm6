class Solution {
    public int numDecodings(String s) {
        int first = 1;
        int second = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            int tmp = 0;
            if(s.charAt(i) != '0'){
                tmp = first;
                if(i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                    tmp += second;
                }
            }
            second = first;
            first = tmp;
        }

        return first;
    }
}

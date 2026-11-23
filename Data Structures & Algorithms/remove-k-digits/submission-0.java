class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for(char c : num.toCharArray()){

            while(k > 0 && !stack.isEmpty() && c < stack.charAt(stack.length() - 1)){
                stack.setLength(stack.length() - 1);
                k--;
            }

            stack.append(c);
        }

        while(k > 0){
            stack.setLength(stack.length() - 1);
            k--;
        }

        int leadingZeros = 0;
        while(leadingZeros < stack.length() && stack.charAt(leadingZeros) == '0'){
            leadingZeros++;
        }

        String result = stack.substring(leadingZeros);
        return result.isEmpty() ? "0" : result;





    }
}

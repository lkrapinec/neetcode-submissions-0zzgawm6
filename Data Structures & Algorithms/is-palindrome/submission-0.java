class Solution {
public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length -1;

        while(start < end){

            while(isNotAplhanumeric(chars[start])){
                start++;

                if(start >= end){
                    return true;
                }
            }

            while(isNotAplhanumeric(chars[end])){
                end--;

                if(start >= end){
                    return true;
                }
            }



            char startChar = isNumber(chars[start]) ? chars[start] : checkForUpperCaseLetter(chars[start]);
            char endChar = isNumber(chars[end]) ? chars[end] : checkForUpperCaseLetter(chars[end]);

            if(startChar != endChar){
                return false;
            }

        start++;
        end--;
        }
        return true;
    }

    public boolean isLetter(char c){
        return isLowerCaseLetter(c) || isUpperCaseLetter(c);
    }

    public boolean isLowerCaseLetter(char c){
        return c >= 'a' && c <= 'z';
    }

    public boolean isUpperCaseLetter(char c){
        return c >= 'A' && c <= 'Z';
    }

    public char toLowerCase(char c){
        return (char) (c - 'A' + 'a');
    }

    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }

    public boolean isNotAplhanumeric(char c){
        return !(isLetter(c) || isNumber(c));
    }

    public char checkForUpperCaseLetter(char c){
         if(isUpperCaseLetter(c)){
                return toLowerCase(c);
        }

        return c;
    }
}

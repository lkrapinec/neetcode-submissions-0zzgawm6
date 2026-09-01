class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        Map<String, Boolean> cache = new HashMap<>();
        int[] longestPalindrome = new int[]{0, 0};

        isPalindrom(0, s.length() - 1, s, cache, longestPalindrome);

        return s.substring(longestPalindrome[0], longestPalindrome[1] + 1);

    }

    private void isPalindrom(int start, int end, String s, Map<String, Boolean> cache, int[] longestPalindrome){
        if(start > end){
            return;
        }
        Boolean result = cache.get(start + "#" + end);
        if(result != null){
            return;
        }

        if(end - start < longestPalindrome[1] - longestPalindrome[0]){
            return;
        }

        int begin = start;
        int stop = end;
        result = true;
        while(begin < stop){
            if(s.charAt(begin) != s.charAt(stop)){
                result = false;
                break;
            }
            begin++;
            stop--;
        }

        cache.put(start + "#" + end, result);

        if(result){
            if(longestPalindrome[1] - longestPalindrome[0] < end - start){
                longestPalindrome[0] = start;
                longestPalindrome[1] = end;
            }
            return;
        }


        isPalindrom(start + 1, end, s, cache, longestPalindrome);
        isPalindrom(start, end - 1, s, cache, longestPalindrome);

    }
}


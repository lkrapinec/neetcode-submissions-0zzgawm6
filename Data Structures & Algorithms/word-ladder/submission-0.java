class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> graph = new HashMap<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            for (int starPosition = 0; starPosition < word.length(); starPosition++) {
                String pattern =
                    word.substring(0, starPosition) + "*" + word.substring(starPosition + 1);
                graph.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new ArrayDeque<>();
        Set<String> passed = new HashSet<>();

        q.offer(beginWord);

        int result = 0;
        while (!q.isEmpty()) {
            int length = q.size();
            result++;
            for (int i = 0; i < length; i++) {
                String word = q.poll();

                if(word.equals(endWord)){
                    return result;
                }

                for (int starPosition = 0; starPosition < word.length(); starPosition++) {
                    String pattern =
                        word.substring(0, starPosition) + "*" + word.substring(starPosition + 1);
                    for(String nextWord : graph.get(pattern)){
                        if(!passed.contains(nextWord)){
                            q.offer(nextWord);
                            passed.add(nextWord);
                        }
                        
                    }
                }
            }
        }

        return 0;
    }
}
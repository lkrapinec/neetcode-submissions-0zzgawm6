

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> patternToWord = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternToWord.computeIfAbsent(pattern, p -> new ArrayList<>()).add(word);
            }
        }

        Set<String> foundWords = new HashSet<>();
        return walk(beginWord, endWord, patternToWord, foundWords);
    }

    private int walk(String startWord, String endWord, Map<String, List<String>> patternToWord,
        Set<String> foundWords) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startWord);
        foundWords.add(startWord);

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return result;
                }
                for (int j = 0; j < curr.length(); j++) {
                    String pattern = curr.substring(0, j) + "*" + curr.substring(j + 1);
                    for (String next : patternToWord.get(pattern)) {
                        if (!foundWords.contains(next)) {
                            queue.offer(next);
                            foundWords.add(next);
                        }
                    }
                }
            }
        }

        return 0;
    }
}

// time: O(n**2)
// space: O(n**2)
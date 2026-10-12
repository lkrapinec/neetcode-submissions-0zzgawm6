

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> wordToAnother = new HashMap<>();

        for (String word : wordList) {
            wordToAnother.put(word, new ArrayList<>());
        }

        for (String word1 : wordList) {
            for (String word2 : wordList) {
                if (!word1.equals(word2) && !wordToAnother.get(word1).contains(word2) && canTransform(word1, word2)) {
                    wordToAnother.get(word1).add(word2);
                    wordToAnother.get(word2).add(word1);
                }
            }
        }

        Set<String> foundWords = new HashSet<>();
        return walk(beginWord, endWord, wordToAnother, foundWords);
    }

    private boolean canTransform(String word1, String word2) {
        int differentChars = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentChars++;
                if (differentChars > 1) {
                    break;
                }
            }
        }

        return differentChars <= 1;
    }

    private int walk(String startWord, String endWord, Map<String, List<String>> wordToAnother,
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

                for (String next : wordToAnother.get(curr)) {
                    if (!foundWords.contains(next)) {
                        queue.offer(next);
                        foundWords.add(next);
                    }
                }
            }
        }

        return 0;
    }
}

//time: O(n**2)
//space: O(n**2)
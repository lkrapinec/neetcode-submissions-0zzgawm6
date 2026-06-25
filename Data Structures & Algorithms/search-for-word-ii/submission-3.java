class Trie {
    boolean isWord;
    Trie[] children;

    public Trie() {
        isWord = false;
        children = new Trie[26];
    }
}

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie dictionary = new Trie();

        for (String word : words) {
            addWord(dictionary, word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, dictionary, new StringBuilder(),
                    new boolean[board.length][board[0].length]);
            }
        }

        return result;
    }

    private void findWords(
        char[][] board, int i, int j, Trie curr, StringBuilder sb, boolean[][] passed) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || passed[i][j] == true) {
            return;
        }

        curr = curr.children[board[i][j] - 'a'];
        if (curr == null) {
            return;
        }

        sb.append(board[i][j]);
        if (curr.isWord) {
            String newWord = sb.toString();
            if (!result.contains(newWord)) {
                result.add(newWord);
            }
        }
        passed[i][j] = true;
        findWords(board, i + 1, j, curr, sb, passed);
        findWords(board, i - 1, j, curr, sb, passed);
        findWords(board, i, j + 1, curr, sb, passed);
        findWords(board, i, j - 1, curr, sb, passed);

        passed[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private void addWord(Trie dictionary, String word) {
        Trie curr = dictionary;
        for (char c : word.toCharArray()) {
            Trie next = curr.children[c - 'a'];
            if (next == null) {
                next = new Trie();
                curr.children[c - 'a'] = next;
            }
            curr = next;
        }
        curr.isWord = true;
    }
}

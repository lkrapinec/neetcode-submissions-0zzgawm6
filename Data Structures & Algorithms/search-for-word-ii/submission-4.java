class Trie {
    String word;
    Trie[] children;

    public Trie() {
        word = null;
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
                findWords(board, i, j, dictionary);
            }
        }

        return result;
    }

    private void findWords(
        char[][] board, int i, int j, Trie curr) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if(board[i][j] == '#'){
            return;
        }

        char c = board[i][j];

        curr = curr.children[c - 'a'];
        if (curr == null) {
            return;
        }

        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '#';
        findWords(board, i + 1, j, curr);
        findWords(board, i - 1, j, curr);
        findWords(board, i, j + 1, curr);
        findWords(board, i, j - 1, curr);

        board[i][j] = c;
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
        curr.word = word;
    }
}

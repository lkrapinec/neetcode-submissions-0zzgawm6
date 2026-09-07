class PrefixTree {
    class Trie {
        Trie[] neighbours;
        boolean isWord;

        public Trie() {
            neighbours = new Trie[26];
        }
    }

    private Trie trie;
    public PrefixTree() {
        trie = new Trie();
    }

    public void insert(String word) {
        Trie curr = trie;

        for (char c : word.toCharArray()) {
            if (curr.neighbours[c - 'a'] == null) {
                curr.neighbours[c - 'a'] = new Trie();
            }

            curr = curr.neighbours[c - 'a'];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            if (curr.neighbours[c - 'a'] == null) {
                return false;
            }
            curr = curr.neighbours[c - 'a'];
        }

        return curr != null && curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie curr = trie;
        for (char c : prefix.toCharArray()) {
            if (curr.neighbours[c - 'a'] == null) {
                return false;
            }

            curr = curr.neighbours[c - 'a'];
        }

        return true;
    }
}

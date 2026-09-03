class WordDictionary {
    class Trie {
        char value;
        Trie[] neighbours;
        boolean isWord;

        public Trie(char value) {
            this.value = value;
            neighbours = new Trie[26];
        }

        public Trie() {
            neighbours = new Trie[26];
        }
    }

    private Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            if (curr.neighbours[c - 'a'] == null) {
                curr.neighbours[c - 'a'] = new Trie(c);
            }

            curr = curr.neighbours[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
      return search(0, word, trie);
    }

    private boolean search(int start, String word, Trie curr){
        if(curr == null){
            return false;
        }
        for (int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (Trie next : curr.neighbours) {
                    if(search(i + 1, word, next)){
                        return true;
                    }
                    
                }
                return false;
            }

            curr = curr.neighbours[word.charAt(i) - 'a'];
            if (curr == null) {
                break;
            }
        }

        return curr != null  && curr.isWord;
    }
}

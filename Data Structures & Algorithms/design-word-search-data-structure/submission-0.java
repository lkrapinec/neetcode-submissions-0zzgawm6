class WordDictionary {
    class Trie {
        char val;
         boolean isWord;
        Map<Character, Trie> children;

        public Trie(char val) {
            this();
            this.val = val;
        }

        public Trie() {
            children = new HashMap<>();
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            Trie next = curr.children.get(c);
            if (next == null) {
                next = new Trie(c);
                curr.children.put(c, next);
            }
            curr = next;
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, trie, 0);
    }

    private boolean dfs(String word, Trie trie, int start) {
        Trie curr = trie;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                Trie next = curr.children.get(c);
                if (next == null) {
                    return false;
                }
                curr = next;
                continue;
            }

            for (Trie child : curr.children.values()) {
                if(dfs(word, child, i+1)){
                    return true;
                }
            }
            return false;
        }

        return curr.isWord;
    }
}

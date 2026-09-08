class Solution {
    private static final int[][] POSITIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    class Trie {
        Trie[] neigbours;
        boolean isWord;

        public Trie() {
            neigbours = new Trie[26];
        }

        public void insertWord(String word) {
            Trie curr = this;

            for (char c : word.toCharArray()) {
                if (curr.neigbours[c - 'a'] == null) {
                    curr.neigbours[c - 'a'] = new Trie();
                }
                curr = curr.neigbours[c - 'a'];
            }

            curr.isWord = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        int longestWord = 0;
        for (String word : words) {
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
            trie.insertWord(word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(i, j, board, trie, result, new StringBuilder());
            }
        }

        return result;
    }

    private void findWord(
        int row, int col, char[][] board, Trie trie, List<String> result, StringBuilder sb) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return;
        }

        if (board[row][col] == '#') {
            return;
        }
        char curr = board[row][col];
      

        Trie next = trie.neigbours[curr - 'a'];

        if (next == null) {
            return;
        }

        sb.append(curr);
        board[row][col] = '#';

        if (next.isWord) {
            result.add(sb.toString());
            next.isWord = false;
        }

            for (int[] position : POSITIONS) {
                int nextRow = row + position[0];
                int nextCol = col + position[1];

                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0
                    && nextCol < board[0].length) {
                    findWord(nextRow, nextCol, board, next, result, sb);
                }
            }
        

        board[row][col] = curr;
        sb.setLength(sb.length() - 1);
    }
}

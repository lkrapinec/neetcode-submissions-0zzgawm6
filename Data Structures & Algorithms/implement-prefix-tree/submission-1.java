class PrefixTree {
    class Node{
        private char val;
        private boolean isWord = false;
        private Map<Character, Node> nodes;

        public Node(char val){
            this();
            this.val = val;
        }
        public Node(){
            nodes = new HashMap<>();
        }

        public char getVal(){
            return val;
        }

        public Node getNode(char c){
            return nodes.get(c);
        }

        public void addNode(Node node){
            nodes.put(node.getVal(), node);
        }

        public void setIsWord(){
            isWord = true;
        }

        public boolean getIsWord(){
            return isWord;
        }


    }
    private Node head;

    public PrefixTree() {
         head = new Node();
    }

    public void insert(String word) {
        Node curr = head;
        for(char c : word.toCharArray()){
            Node next = curr.getNode(c);
            if(next == null){
                next = new Node(c);
                curr.addNode(next);
            }
            curr = next;
        }
        curr.setIsWord();
    }

    public boolean search(String word) {
        Node curr = head;
        for(char c : word.toCharArray()){
             Node next = curr.getNode(c);
             if(next == null){
                return false;
             }
             curr = next;
        }
        return curr.getIsWord();
    }

    public boolean startsWith(String prefix) {
        Node curr = head;
        for(char c : prefix.toCharArray()){
             Node next = curr.getNode(c);
             if(next == null){
                return false;
             }
             curr = next;
        }

        return true;
    }
}

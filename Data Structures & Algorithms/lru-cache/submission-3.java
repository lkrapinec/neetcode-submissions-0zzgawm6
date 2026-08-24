class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int val;

        public Node(){}

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private Node leastRecent;
    private Node mostRecent;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        leastRecent = null;
        mostRecent = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }

        remove(node);
        add(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node(key, value);
            map.put(key, node);
        }else{
            node.val = value;
        }
        remove(node);
        add(node);

        if(map.size() > capacity){
            map.remove(leastRecent.key);
            remove(leastRecent);
        }
    }

    private void remove(Node node){
       if(node.next != null){
        node.next.prev = node.prev;
       }

       if(node.prev != null){
        node.prev.next = node.next;
       }

       if(node == leastRecent){
        leastRecent = node.next;
       }

       if(node == mostRecent){
        mostRecent = node.prev;
       }

        node.next = null;
        node.prev = null;        
    }
    private void add(Node node){
        if(leastRecent == null){
            leastRecent = node;
            mostRecent = node;

            return;
        }

        node.prev = mostRecent;
        mostRecent.next = node;
        mostRecent = node;
    }
}

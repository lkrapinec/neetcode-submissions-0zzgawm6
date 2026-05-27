class LRUCache {
    class Node{
        public int val;
        public int key;
        public Node prev;
        public Node next;

        public Node(){
        }
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Map<Integer, Node> cache;
    private int capacity;
    private Node leastRecent;
    private Node mostRecent;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        Node current = cache.get(key);

        if(current == null){
            return -1;
        }

        removeNode(current);
        addNode(current);

        return current.val;
    }
    
    public void put(int key, int value) {
        removeNode(cache.get(key));

        Node newNode = new Node(key, value);
        addNode(newNode);
        cache.put(key, newNode);

        if(cache.size() > capacity){
            cache.remove(leastRecent.key);
            removeNode(leastRecent);
        }
    }
    private void addNode(Node node){
        if(mostRecent != null){
            mostRecent.next = node;
        }
        node.prev = mostRecent;
        mostRecent = node;

        if(leastRecent == null){
            leastRecent = node;
        }
    }
    private void removeNode(Node node){
        if(node == null){
            return;
        }
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
}

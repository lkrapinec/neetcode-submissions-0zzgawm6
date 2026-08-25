class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> cache;
    private Node leastRecent;
    private Node mostRecent;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }
    private void remove(Node node) {
        if (node == null) {
            return;
        }
        if (node == leastRecent) {
            leastRecent = leastRecent.next;
        }
        if (node == mostRecent) {
            mostRecent = mostRecent.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = null;
        node.next = null;
    }

    private void add(Node node) {
        if (node == mostRecent) {
            return;
        }

        if (leastRecent == null) {
            leastRecent = node;
            mostRecent = node;

            return;
        }

        node.prev = mostRecent;
        mostRecent.next = node;
        mostRecent = node;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        remove(node);
        add(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            node = new Node(key, value);
            cache.put(key, node);
        }else{
            node.val = value;
            remove(node);
        }

        add(node);

        if(cache.size() > capacity){
            Node lru = leastRecent;
            leastRecent = leastRecent.next;

            cache.remove(lru.key);
            remove(lru);   
        }
    }
}

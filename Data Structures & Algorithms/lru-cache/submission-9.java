class LRUCache {
    class Node {
        Integer val;
        Integer key;
        Node next;
        Node prev;

        public Node(){
        }

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            
        }
    }

    Node first;
    Node last;

    Map<Integer, Node> map; 
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
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
        }else{
            node.val = value;
        }
        map.put(key, node);

        remove(node);
        add(node);

        if(map.size() > capacity){
            Node tmp = last;
            remove(tmp);
            map.remove(tmp.key);
        }
    }

    private void remove(Node node){
        if(last == null || first == null){
            return;
        }

        if(first.equals(node)){
            first = first.prev;
        }

        if(last.equals(node)){
            last = last.next;
        }

        

        if(node.prev != null){
            node.prev.next = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;

    }

    private void add(Node node){
        if(last == null){
            last = node;
        }

        if(first != null){
            first.next = node;
            node.prev = first;
        }

        first = node;
    }
}





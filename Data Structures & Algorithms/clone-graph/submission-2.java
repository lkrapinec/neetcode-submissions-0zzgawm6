/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        Node newNode = map.get(node);

        if(newNode != null){
            return newNode;
        }

        newNode = new Node(node.val);
        map.put(node, newNode);


        for (Node neighbor : node.neighbors) {
            Node newNeighbor = dfs(neighbor, map);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}

// for each node I need to create a new object
// I can use map to connect existing node with new node
// already visited nodes should be skipped

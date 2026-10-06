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
        Set<Node> visited = new HashSet<>();

        return dfs(node, map, visited);
    }

    private Node dfs(Node node, Map<Node, Node> map, Set<Node> visited) {
        Node newNode = map.get(node);

        if (newNode == null) {
            newNode = new Node(node.val);
            map.put(node, newNode);
        }

        visited.add(node);

        for (Node neighbor : node.neighbors) {
            Node newNeighbor;
            if (!visited.contains(neighbor)) {
                 newNeighbor = dfs(neighbor, map, visited);
            }else{
                newNeighbor = map.get(neighbor);
            }

            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}

// for each node I need to create a new object
// I can use map to connect existing node with new node
// already visited nodes should be skipped

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
        if(node == null){
            return node;
        }

        Map<Node, Node> visited = new HashMap<>();

        return dfs(node, visited); 

    }

    private Node dfs(Node node, Map<Node, Node> visited){
        Node existingNode = visited.get(node);
        if(existingNode != null){
            return existingNode;
        }

        
        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        ArrayList<Node> clonedNeighbors = new ArrayList<>();
        for(Node neighbor : node.neighbors){
            Node clonedNeighbor = dfs(neighbor, visited);
            if(clonedNeighbor != null){
                clonedNeighbors.add(clonedNeighbor);
            }
        }

        newNode.neighbors = clonedNeighbors;

        return newNode;
    }
}

//use dfs to find last unvisited node, then create new node from that
//have visited array



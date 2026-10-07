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
        Map<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew){
        if(node == null){
            return null;
        }

        Node newNode = oldToNew.get(node);
        if(newNode != null){
            return newNode;
        }

        newNode = new Node(node.val);
        oldToNew.put(node, newNode);
        for(Node neigbour : node.neighbors){

            newNode.neighbors.add(dfs(neigbour, oldToNew));
        }

        return newNode;
    }

}